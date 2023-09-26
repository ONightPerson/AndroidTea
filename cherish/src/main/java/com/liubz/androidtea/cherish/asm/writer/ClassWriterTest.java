package com.liubz.androidtea.cherish.asm.writer;

import com.liubz.androidtea.cherish.asm.User;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 9/26/23 2:40 PM
 */
public class ClassWriterTest implements Opcodes {

    public static void main(String[] args) {
        try {
//            copyUserClass();
            addFiledToClass();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyUserClass() throws IOException {
        ClassReader cr = new ClassReader(User.class.getName());
        ClassWriter cw = new ClassWriter(ASM4);
        cr.accept(cw, ASM4);

        FileOutputStream fos = new FileOutputStream("/Users/liubaozhu/Desktop/User.class");
        fos.write(cw.toByteArray());
        fos.flush();
        fos.close();
    }

    public static void addFiledToClass() throws IOException {
        ClassReader cr = new ClassReader(User.class.getName());
        ClassWriter cw = new ClassWriter(0);
        AddFieldClassVisitor afcv = new AddFieldClassVisitor(cw);
        cr.accept(afcv, 0);

        FileOutputStream fos = new FileOutputStream("/Users/liubaozhu/Desktop/User.class");
        fos.write(cw.toByteArray());
        fos.flush();
        fos.close();
    }
}
