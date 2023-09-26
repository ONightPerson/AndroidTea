package com.liubz.androidtea.cherish.asm.writer;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 9/26/23 3:22 PM
 */
public class AddFieldClassVisitor extends ClassVisitor implements Opcodes {

    public AddFieldClassVisitor(ClassVisitor classVisitor) {
        super(ASM5, classVisitor);
    }

    @Override
    public void visitEnd() {
        if (cv != null) {
            // TODO: 初始化值失败
            FieldVisitor fv = cv.visitField(ACC_PUBLIC + ACC_STATIC, "timer", "J", null, new Long(2L));
            if (fv != null) {
                fv.visitEnd();
            }
            cv.visitEnd();
        }
    }
}
