package com.liubz.androidtea.cherish.asm.writer;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 9/26/23 5:50 PM
 */
public class HelloWorldGenerator implements Opcodes {

    public static void generateByteCode() throws IOException {
        // COMPUTE_FRAMES > COMPUTE_MAXS
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(V1_8, ACC_PUBLIC | ACC_SUPER, "com/liubz/androidtea/cherish/asm/writer/HelloWorld", null, "java/lang/Object", null);

        // 默认构造方法
        MethodVisitor mv1 = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        mv1.visitCode();
        mv1.visitVarInsn(ALOAD, 0);
        mv1.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        mv1.visitInsn(RETURN);
        mv1.visitEnd();

        // toString方法
        MethodVisitor mv2 = cw.visitMethod(ACC_PUBLIC, "toString", "()Ljava/lang/String", null, null);
        mv2.visitCode();
        mv2.visitLdcInsn("Hello World");
        mv2.visitInsn(ARETURN);
        mv2.visitEnd();

        FileOutputStream fos = new FileOutputStream("/Users/liubaozhu/Desktop/HelloWorld.class");
        fos.write(cw.toByteArray());
        fos.flush();
        fos.close();
    }
}
