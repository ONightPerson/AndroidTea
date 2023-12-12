package com.liubz.androidtea.cherish.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 12/11/23 4:16 PM
 */
public class JOLTest {
    public static void main(String[] args) {
        // 步骤二：创建对象
        Object obj = new Object();
        // 步骤三：打印对象内存布局
        // 1. 输出虚拟机与对象内存布局相关的信息
        System.out.println("输出对象内存布局：");
        System.out.println(VM.current().details());
        // 2. 输出对象内存布局信息
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        // 查看数组对象的对象头中的数组长度字段
        char[] str = new char[2];
        System.out.println("查看数组对象的对象头中的数组长度字段:");
        System.out.println(ClassLayout.parseInstance(str).toPrintable());
    }
}
