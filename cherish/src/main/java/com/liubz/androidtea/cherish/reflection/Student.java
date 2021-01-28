package com.liubz.androidtea.cherish.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by liubaozhu on 2021/1/17
 * 常见的反射操作
 */
@SuppressWarnings(value = "unchecked")
@Deprecated
public class Student {

    private int mAge;
    private String mName;

    protected String mHobby;
    private ArrayList<Friend> mFriends;

    public Student() {
    }

    public Student(String name, int age/*, ArrayList<Friend> friends*/) {
        mAge = age;
        mName = name;
        mFriends = new ArrayList<>();
//        if (friends != null) {
//            mFriends.addAll(friends);
//        }
    }

    protected void setHobby(String hobby) {
        mHobby = hobby;
    }

    public String getName() {
        return mName;
    }

    public int getAge() {
        return mAge;
    }

    public ArrayList<Friend> getFriends() {
        return mFriends;
    }

    static class Friend extends Student {
        int intimacy;
    }

    public static void main(String[] args) {
        // 获取Student类对应的class对象
        Student student = new Student("zhuzi", 31);
        Class<?> stuClass = student.getClass();
        // 获取stuClass对象所有的构造器
        Constructor<?>[] constructors = stuClass.getDeclaredConstructors();
        System.out.println("Student的全部构造器如下：");
        for (Constructor<?> constructor : constructors) {
            System.out.println("constructor: " + constructor);
        }
        // 获取特定参数的构造函数
        try {
            Constructor<?> constructor = stuClass.getConstructor(String.class, int.class);
            System.out.println("特定参数的constructor: " + constructor);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        // 获取stuClass对象的所有public constructor
        Constructor<?>[] pubConstructor = stuClass.getConstructors();
        System.out.println("Student的全部public构造器如下：");
        for (Constructor<?> constructor : pubConstructor) {
            System.out.println("constructor: " + constructor);
        }
        // 获取stuClass对象所有Method
        System.out.println("获取stuClass对象所有Method");
        Method[] methods = stuClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        Method[] pubMethods = stuClass.getMethods();
        System.out.println("获取stuClass对象所有 public Method");
        for (Method method : pubMethods) {
            System.out.println(method);
        }
        System.out.println("获取特定参数的方法");
        try {
            Method gfMethods = stuClass.getMethod("getFriends");
            System.out.println("gfMethods: " + gfMethods);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        // 获取stuClass对象对应类的所有注解
        System.out.println("获取stuClass对象对应类的所有注解");
        Annotation[] annotations = stuClass.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        // 获取public annotations
        System.out.println("获取public annotations:");
        Annotation[] pubAnno = stuClass.getAnnotations();
        for (Annotation annotation : pubAnno) {
            System.out.println(annotation);
        }
        System.out.println("该Class元素上的@SuppressWarnings注释为："
                + stuClass.getAnnotation(SuppressWarnings.class));
        Class<?>[] pubMemberClass = stuClass.getClasses();
        System.out.println("public member classes: ");
        for (Class<?> clazz : pubMemberClass) {
            System.out.println(clazz);
        }
        Class<?>[] allMemberClass = stuClass.getDeclaredClasses();
        System.out.println("all member classes: ");
        for (Class<?> clazz : allMemberClass) {
            System.out.println(clazz);
        }

        try {
            Class<?> innerClass = Class.forName("com.liubz.androidtea.cherish.reflection"
                    + ".Student$Friend");
            System.out.println("declaring class: " + innerClass.getDeclaringClass());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Student类所在包： " + stuClass.getPackage());
        System.out.println("Student类的父类: " + stuClass.getSuperclass());
        // 使用反射调用方法
        try {
            Method method = stuClass.getMethod("getName");
            method.setAccessible(true);
            String name = (String) method.invoke(student);
            System.out.println("name: " + name);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        // 使用反射访问属性
        try {
            Field nameField = stuClass.getDeclaredField("mName");
            nameField.setAccessible(true);
            nameField.set(student, "Lucy");
            Field ageField = stuClass.getDeclaredField("mAge");
            ageField.setAccessible(true);
            ageField.set(student, 19);
            System.out.println("student --> age: " + student.getAge() + ", name: " + student.getName());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
