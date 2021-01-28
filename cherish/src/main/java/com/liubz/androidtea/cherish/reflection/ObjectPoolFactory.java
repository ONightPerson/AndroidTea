package com.liubz.androidtea.cherish.reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by liubaozhu on 2021/1/17
 * 使用反射生成并操作对象
 */
public class ObjectPoolFactory {
    private final Map<String, Object> objectPool = new HashMap<>();

    private Object createObject(String clazzName)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException {

        Class<?> clazz = Class.forName(clazzName);
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
        return constructor.newInstance("xiaoqing", 19);
    }

    public void initPool(String fileName)
            throws IllegalAccessException, ClassNotFoundException, InstantiationException,
            NoSuchMethodException, InvocationTargetException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
            Properties props = new Properties();
            props.load(fis);
            for (String name : props.stringPropertyNames()) {
                String className = props.getProperty(name);
                Object obj = createObject(className);
                objectPool.put(name, obj);
            }
        } catch (IOException ex) {
            System.out.println("读取 " + fileName + "异常");
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Object getObject(String name) {
        return objectPool.get(name);
    }

    public static void main(String[] args)
            throws IllegalAccessException, InstantiationException, ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException {
        ObjectPoolFactory pf = new ObjectPoolFactory();
        pf.initPool(
                "/Users/liubaozhu/CommonRepo/AndroidTea/cherish/src/main/java/com/liubz"
                        + "/androidtea/cherish/reflection/obj.txt");
        Student student = (Student) pf.getObject("a");
        System.out.println(student.getName() + ", " + student.getAge());

    }
}
