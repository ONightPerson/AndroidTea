package com.liubz.androidtea.serialization;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

    static class User implements Serializable {
        private static final long serialVersionUID = 1;
        String name;
        int age;

        @Override
        public String toString() {
            return "User{" +
              "name='" + name + '\'' +
              ", age=" + age +
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
            User user = new User();
            user.name = "ONightPerson";
            user.age = 33;
            oos.writeObject(user);
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
            User user = (User) ois.readObject();
            System.out.println("user: " + user + ", className: " + User.class.getName());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
