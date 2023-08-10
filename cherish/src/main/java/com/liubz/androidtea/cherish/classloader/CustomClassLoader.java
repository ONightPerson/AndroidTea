package com.liubz.androidtea.cherish.classloader;

import com.liubz.androidtea.cherish.utils.FileUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2022/11/30 11:45 AM
 */
public class CustomClassLoader extends ClassLoader {

    public static void main(String[] params) {
//        CustomClassLoader ccl = new CustomClassLoader("/Users/liubaozhu/Desktop");
//        try {
//            Class c = ccl.loadClass("com.example.Hello");
//            if (c != null) {
//                Object obj = c.newInstance();
//                System.out.println(obj.getClass().getClassLoader());
//                Method method = c.getDeclaredMethod("say", null);
//                method.setAccessible(true);
//                method.invoke(obj, null);
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }

    }

    private final String mPath;

    public CustomClassLoader(String path) {
        this.mPath = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = loadClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException("CustomClassLoader load class fail");
        }
        return defineClass(name, classData, 0, classData.length);
    }

    private byte[] loadClassData(String name) {
        String fileName = getFileName(name);
        File file = new File(mPath, fileName);
        System.out.println("file: " + file.toString());
        InputStream in = null;
        ByteArrayOutputStream baos = null;
        try {
            in = new FileInputStream(file);
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024 * 4];
            int count;
            while ((count = in.read(buffer)) != -1) {
                baos.write(buffer, 0, count);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            FileUtils.closeStream(in);
            FileUtils.closeStream(baos);
        }
        return null;
    }

    private String getFileName(String name) {
        if (name == null) {
            return null;
        }
        int index = name.lastIndexOf('.');
        if (index == -1) {
            return name + ".class";
        }
        return name.substring(index + 1) + ".class";
    }
}
