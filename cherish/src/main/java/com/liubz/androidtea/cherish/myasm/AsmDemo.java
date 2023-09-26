package com.liubz.androidtea.cherish.myasm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.lang.String;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 9/25/23 7:44 PM
 */
public class AsmDemo extends ClassLoader implements Opcodes {

    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, InvocationTargetException {
        ClassReader cr = new ClassReader(Foo.class.getName());
        ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_MAXS);
        ClassVisitor cv = new MethodChangeClassAdapter(cw);
        cr.accept(cv, ASM4);

//        // 新增一个方法
        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "add", "([Ljava/lang/String;)V", null, null);
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn("this is add method print!");
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
        mv.visitInsn(RETURN);

        mv.visitMaxs(0, 0);
        mv.visitEnd();

        AsmDemo demo = new AsmDemo();
        byte[] code = cw.toByteArray();
        Class<?> exampleClass = demo.defineClass(Foo.class.getName(), code, 0, code.length);
//        System.out.println("methods数量: " + exampleClass.getMethods().length);



        System.out.println("***************************");
        System.out.println("methods数量: " + exampleClass.getMethods().length);
        for (Method method : exampleClass.getMethods()) {
            System.out.println(method);
        }
        // uses the dynamically generated class to print 'Helloworld'
        // 調用changeMethodContent，修改方法內容
        exampleClass.getMethods()[0].invoke(exampleClass.newInstance(), null);
        exampleClass.getMethods()[1].invoke(exampleClass.newInstance(), null);

        System.out.println("***************************");
        // 調用execute,修改方法名

        System.out.println("method0: " + exampleClass.getMethods()[0]);
        System.out.println("method1: " + exampleClass.getMethods()[1]);
        System.out.println("method2: " + exampleClass.getMethods()[2]);
//        exampleClass.getMethods()[2].invoke(exampleClass.newInstance(), new String[] {"2"});
        exampleClass.getMethods()[2].invoke(null, (Object) new String[] {"2", "3"});
        // gets the bytecode of the Example class, and loads it dynamically

//        FileOutputStream fos = new FileOutputStream("e:\\Example.class");
//        fos.write(code);
//        fos.close();
    }
}
