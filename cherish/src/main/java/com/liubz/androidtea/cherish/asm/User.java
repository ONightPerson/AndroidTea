package com.liubz.androidtea.cherish.asm;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 9/26/23 11:19 AM
 */
public class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void m() throws Exception {
        Thread.sleep(1000L);
    }
}
