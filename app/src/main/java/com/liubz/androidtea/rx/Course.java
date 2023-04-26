package com.liubz.androidtea.rx;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/4/25 11:16 AM
 */
public class Course {
    public String name;

    public Course(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
          "name='" + name + '\'' +
          '}';
    }
}
