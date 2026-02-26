package com.liubz.androidtea.anim.opengl;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Random;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * 粒子渲染器原理：基于物理公式 S = S0 + V * t
 * 
 * 设计思想：
 * 1. CPU负责初始状态：只在初始化时确定粒子的起点、速度和出生时间。
 * 2. GPU负责动态计算：位移计算全部在 Vertex Shader 中完成，极大地减轻了 CPU 压力。
 * 3. 内存优化：使用 Direct Buffer (Native内存) 存储粒子属性，实现高速数据传递。
 */
public class GLParticleRenderer implements GLSurfaceView.Renderer {

    // 【顶点着色器】：处理每个粒子的物理位置
    // attribute: 每个粒子独有的属性
    // uniform: 所有粒子公用的全局变量
    private static final String VERTEX_SHADER =
            "uniform mat4 u_Matrix;\n" +        // 投影矩阵：解决屏幕拉伸问题
            "uniform float u_CurrentTime;\n" +  // 全局时间：驱动粒子运动的“核心心跳”
            "attribute vec3 a_StartPosition;\n" + // 属性：每个粒子的起始点
            "attribute vec3 a_Direction;\n" +     // 属性：每个粒子的运动向量
            "attribute float a_BirthTime;\n" +    // 属性：每个粒子的“生日”
            "varying float v_ElapsedTime;\n" +    // 传给片元着色器的变量
            "void main() {\n" +
            "    // 计算粒子已存活的时间\n" +
            "    v_ElapsedTime = u_CurrentTime - a_BirthTime;\n" +
            "    // 物理公式实现：当前位置 = 起点 + (速度 * 时间)\n" +
            "    vec3 currentPosition = a_StartPosition + (a_Direction * v_ElapsedTime);\n" +
            "    // 将计算出的 3D 坐标通过矩阵转换映射到屏幕上\n" +
            "    gl_Position = u_Matrix * vec4(currentPosition, 1.0);\n" +
            "    // 设置粒子在屏幕上的显示直径（像素）\n" +
            "    gl_PointSize = 25.0;\n" +
            "}";

    // 【片元着色器】：处理粒子的视觉外观（颜色、透明度、形状）
    private static final String FRAGMENT_SHADER =
            "precision mediump float;\n" +
            "varying float v_ElapsedTime;\n" +
            "void main() {\n" +
            "    // 透明度计算：存活 2 秒后完全消失\n" +
            "    float alpha = 1.0 - (v_ElapsedTime / 2.0);\n" +
            "    if (alpha < 0.0) discard;\n" + // 如果已死亡，直接丢弃，不执行渲染
            "    \n" +
            "    // 形状美化：默认点是方形的，通过计算到中心的距离，丢弃圆外部分的像素\n" +
            "    float d = distance(gl_PointCoord, vec2(0.5, 0.5));\n" +
            "    if (d > 0.5) discard;\n" +
            "    \n" +
            "    // 输出最终颜色：橙黄色 (R=1.0, G=0.6, B=0.2)\n" +
            "    gl_FragColor = vec4(1.0, 0.6, 0.2, alpha);\n" +
            "}";

    private static final int PARTICLE_COUNT = 500;
    // 数据跨度：3(起点) + 3(方向) + 1(出生时间) = 7 个 float
    private static final int STRIDE = 7; 
    private FloatBuffer mParticleBuffer;
    private int mProgram;
    private long mStartTime;
    private final float[] mProjectionMatrix = new float[16];

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        // 背景设为透明（0,0,0,0）
        GLES20.glClearColor(0f, 0f, 0f, 0f); 
        
        // 开启混合模式：实现粒子重叠时的半透明和发光效果
        GLES20.glEnable(GLES20.GL_BLEND);
        // 使用加法混合（Additive Blending）：重叠越多越亮
        GLES20.glBlendFunc(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE);

        mProgram = createProgram(VERTEX_SHADER, FRAGMENT_SHADER);
        initParticleData();
        mStartTime = System.currentTimeMillis();
    }

    /**
     * 初始化 500 个粒子的初始属性
     */
    private void initParticleData() {
        float[] particles = new float[PARTICLE_COUNT * STRIDE];
        Random random = new Random();
        for (int i = 0; i < PARTICLE_COUNT; i++) {
            int offset = i * STRIDE;
            // 1. 设置所有粒子初始都在中心 (0,0,0)
            particles[offset] = 0f;
            particles[offset + 1] = 0f;
            particles[offset + 2] = 0f;
            
            // 2. 赋予随机的爆发速度和方向
            particles[offset + 3] = (random.nextFloat() - 0.5f) * 2f;
            particles[offset + 4] = (random.nextFloat() - 0.5f) * 2f;
            particles[offset + 5] = 0f;
            
            // 3. 随机出生时间：让粒子分批次产生，形成连贯的喷发感
            particles[offset + 6] = random.nextFloat() * 2.0f;
        }
        
        // 将数据上传至 Native 内存，防止 Java GC 回收导致渲染卡顿
        mParticleBuffer = ByteBuffer.allocateDirect(particles.length * 4)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer()
                .put(particles);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
        // 计算纵横比，防止圆形粒子因屏幕比例被压成椭圆
        float aspectRatio = width > height ? (float) width / (float) height : (float) height / (float) width;
        if (width > height) {
            Matrix.orthoM(mProjectionMatrix, 0, -aspectRatio, aspectRatio, -1f, 1f, -1f, 1f);
        } else {
            Matrix.orthoM(mProjectionMatrix, 0, -1f, 1f, -aspectRatio, aspectRatio, -1f, 1f);
        }
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        // 清除上一帧画面
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        GLES20.glUseProgram(mProgram);

        // 获取并计算当前的“相对时间”
        float currentTime = (System.currentTimeMillis() - mStartTime) / 1000f;
        currentTime = currentTime % 4.0f; // 4秒一个循环周期

        // 传递全局统一变量 (Uniforms)
        int uMatrixLoc = GLES20.glGetUniformLocation(mProgram, "u_Matrix");
        GLES20.glUniformMatrix4fv(uMatrixLoc, 1, false, mProjectionMatrix, 0);

        int uTimeLoc = GLES20.glGetUniformLocation(mProgram, "u_CurrentTime");
        GLES20.glUniform1f(uTimeLoc, currentTime);

        // 绑定顶点属性 (Attributes)：告诉 GPU 如何在内存中“跳着读”数据
        // 1. 读取起点
        mParticleBuffer.position(0);
        int aPosLoc = GLES20.glGetAttribLocation(mProgram, "a_StartPosition");
        GLES20.glVertexAttribPointer(aPosLoc, 3, GLES20.GL_FLOAT, false, STRIDE * 4, mParticleBuffer);
        GLES20.glEnableVertexAttribArray(aPosLoc);

        // 2. 读取方向速度 (偏移量为 3)
        mParticleBuffer.position(3);
        int aDirLoc = GLES20.glGetAttribLocation(mProgram, "a_Direction");
        GLES20.glVertexAttribPointer(aDirLoc, 3, GLES20.GL_FLOAT, false, STRIDE * 4, mParticleBuffer);
        GLES20.glEnableVertexAttribArray(aDirLoc);

        // 3. 读取出生时间 (偏移量为 6)
        mParticleBuffer.position(6);
        int aBirthLoc = GLES20.glGetAttribLocation(mProgram, "a_BirthTime");
        GLES20.glVertexAttribPointer(aBirthLoc, 1, GLES20.GL_FLOAT, false, STRIDE * 4, mParticleBuffer);
        GLES20.glEnableVertexAttribArray(aBirthLoc);

        // 绘制：一次性绘制所有点，GPU 将并行处理 500 个顶点的着色器逻辑
        GLES20.glDrawArrays(GLES20.GL_POINTS, 0, PARTICLE_COUNT);
    }

    private int createProgram(String vertexSource, String fragmentSource) {
        int vertexShader = loadShader(GLES20.GL_VERTEX_SHADER, vertexSource);
        int fragmentShader = loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentSource);
        int program = GLES20.glCreateProgram();
        GLES20.glAttachShader(program, vertexShader);
        GLES20.glAttachShader(program, fragmentShader);
        GLES20.glLinkProgram(program);
        return program;
    }

    private int loadShader(int type, String shaderCode) {
        int shader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);
        return shader;
    }
}
