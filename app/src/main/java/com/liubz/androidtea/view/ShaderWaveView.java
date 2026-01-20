package com.liubz.androidtea.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class ShaderWaveView extends View {

    // 渐变和着色器
    private LinearGradient gradient;
    private Paint wavePaint;

    // 波浪参数
    private float waveAmplitude = 100f;
    private float waveFrequency = 0.01f;
    private float waveSpeed = 0.08f;
    private float wavePhase = 0f;

    // 动画
    private ValueAnimator animator;

    // 渲染区域
    private final RectF waveRect = new RectF();

    // 性能优化
    private Bitmap waveBitmap;
    private Canvas waveCanvas;
    private boolean useShader = true;

    public ShaderWaveView(Context context) {
        super(context);
        init();
    }

    public ShaderWaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ShaderWaveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(View.LAYER_TYPE_HARDWARE, null);

        wavePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        wavePaint.setStyle(Paint.Style.FILL);

        // 创建渐变
        createGradient();

        setupAnimation();
    }

    private void createGradient() {
        int[] colors = {
                Color.parseColor("#004A90E2"),
                Color.parseColor("#FF4A90E2"),
                Color.parseColor("#FF5CA0FF"),
                Color.parseColor("#FF4A90E2"),
                Color.parseColor("#004A90E2")
        };

        float[] positions = {0f, 0.3f, 0.5f, 0.7f, 1f};

        gradient = new LinearGradient(0, 0, 0, 1, colors, positions, Shader.TileMode.CLAMP);
        wavePaint.setShader(gradient);
    }

    private void setupAnimation() {
        animator = ValueAnimator.ofFloat(0f, 1f);
        animator.setDuration(2000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                wavePhase += waveSpeed;
                invalidate();
            }
        });
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        waveRect.set(0, 0, w, h);

        // 更新渐变
        if (gradient != null) {
            gradient = new LinearGradient(0, 0, 0, h,
                    new int[]{
                            Color.parseColor("#004A90E2"),
                            Color.parseColor("#FF4A90E2"),
                            Color.parseColor("#FF5CA0FF"),
                            Color.parseColor("#FF4A90E2"),
                            Color.parseColor("#004A90E2")
                    },
                    new float[]{0f, 0.3f, 0.5f, 0.7f, 1f},
                    Shader.TileMode.CLAMP
            );
            wavePaint.setShader(gradient);
        }

        // 创建位图缓存
        if (waveBitmap != null) {
            waveBitmap.recycle();
        }
        waveBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        waveCanvas = new Canvas(waveBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (getWidth() == 0 || getHeight() == 0) return;

        if (useShader) {
            drawWithShader(canvas);
        } else {
            drawWithPath(canvas);
        }
    }

    private void drawWithShader(Canvas canvas) {
        // 清空画布
        canvas.drawColor(Color.TRANSPARENT);

        // 保存画布状态
        canvas.save();

        // 应用波浪变形
        Path wavePath = new Path();
        int width = getWidth();
        int height = getHeight();

        // 创建波浪路径
        wavePath.moveTo(0, height);

        // 映射系数：将 sin 的 [-1, 1] 映射到 [0.5, 1] -> (sin + 3) / 4
        float amplitudeScale = ((float) Math.sin(wavePhase * 0.5f) + 3f) / 4f;

        for (int x = 0; x <= width; x += 10) {
            float y = height / 2f +
                    waveAmplitude * (float) Math.sin(x * waveFrequency + wavePhase) * amplitudeScale;

            wavePath.lineTo(x, y);
        }

        wavePath.lineTo(width, height);
        wavePath.lineTo(0, height);
        wavePath.close();

        // 裁剪画布并绘制渐变
        canvas.clipPath(wavePath);
        canvas.drawRect(waveRect, wavePaint);

        // 恢复画布状态
        canvas.restore();

        // 添加高光效果
        drawHighlight(canvas);
    }

    private void drawWithPath(Canvas canvas) {
        // 使用位图缓存
        if (waveBitmap != null && waveCanvas != null) {
            // 清空缓存画布
            waveCanvas.drawColor(Color.TRANSPARENT);

            // 绘制多层波浪
            for (int i = 0; i < 3; i++) {
                drawWaveLayer(waveCanvas, i);
            }

            // 绘制缓存到屏幕
            canvas.drawBitmap(waveBitmap, 0, 0, wavePaint);
        }
    }

    private void drawWaveLayer(Canvas canvas, int layer) {
        Path path = new Path();
        int width = getWidth();
        int height = getHeight();
        float centerY = height / 2f;

        float amplitude = waveAmplitude * (0.8f - layer * 0.2f);
        float frequency = waveFrequency * (1 + layer * 0.1f);
        float phase = wavePhase + layer * 0.5f;

        path.moveTo(0, centerY);

        for (int x = 0; x <= width; x += 5) {
            float y = centerY + amplitude * (float) Math.sin(x * frequency + phase);

            if (x == 0) {
                path.lineTo(x, y);
            } else {
                path.lineTo(x, y);
            }
        }

        path.lineTo(width, height);
        path.lineTo(0, height);
        path.close();

        int alpha = 255 - layer * 50;
        wavePaint.setColor(Color.argb(alpha, 76, 144, 226));
        wavePaint.setShader(null);

        canvas.drawPath(path, wavePaint);
    }

    private void drawHighlight(Canvas canvas) {
        Paint highlightPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        highlightPaint.setStyle(Paint.Style.FILL);

        // 创建高光渐变
        RadialGradient radialGradient = new RadialGradient(
                getWidth() * 0.7f, getHeight() * 0.3f,
                getWidth() * 0.5f,
                Color.parseColor("#20FFFFFF"),
                Color.TRANSPARENT,
                Shader.TileMode.CLAMP
        );

        highlightPaint.setShader(radialGradient);
        canvas.drawRect(waveRect, highlightPaint);
    }

    public void setWaveAmplitude(float amplitude) {
        this.waveAmplitude = amplitude;
        invalidate();
    }

    public void setWaveFrequency(float frequency) {
        this.waveFrequency = frequency;
        invalidate();
    }

    public void setWaveSpeed(float speed) {
        this.waveSpeed = speed;
    }

    public void start() {
        if (animator != null && !animator.isRunning()) {
            animator.start();
        }
    }

    public void stop() {
        if (animator != null && animator.isRunning()) {
            animator.cancel();
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        start();
    }

    @Override
    protected void onDetachedFromWindow() {
        stop();
        if (waveBitmap != null) {
            waveBitmap.recycle();
            waveBitmap = null;
            waveCanvas = null;
        }
        super.onDetachedFromWindow();
    }
}
