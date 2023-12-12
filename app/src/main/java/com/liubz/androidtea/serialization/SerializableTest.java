package com.liubz.androidtea.serialization;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/4/21 11:51 AM
 */
public class SerializableTest {

    private static final String FILE_NAME = "user.1";

    static class Student implements Serializable {
        private static final long serialVersionUID = 1L;

        public String name;
        public int age;
        public String sex;
        public String className;

        public Student(String name, int age, String sex, String className) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.className = className;
        }

        @Override
        public String toString() {
            return "Student{" +
              "name='" + name + '\'' +
              ", age=" + age +
              ", sex=" + sex +
              ", className=" + className +
              '}';
        }
    }

    public static void main(String[] args) {
       saveObject();
       restoreObject();
    }

    private static void saveObject() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File("/Users/liubaozhu/Desktop", FILE_NAME));
            oos = new ObjectOutputStream(fos);
            Student student = new Student("小明", 18, "男", "高中三年级");
            oos.writeObject(student);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    private static void restoreObject() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(new File("/Users/liubaozhu/Desktop", FILE_NAME));
            ois = new ObjectInputStream(fis);
            Student student = (Student) ois.readObject();
            System.out.println("user: " + student + ", className: " + Student.class.getName());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
