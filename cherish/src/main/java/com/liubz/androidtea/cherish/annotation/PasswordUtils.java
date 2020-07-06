package com.liubz.androidtea.cherish.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * author: created by liubaozhu on 2020/7/4
 * email: liubaozhu@baidu.com
 */
public class PasswordUtils {


    @UseCase(id = 2, description = "encrypt password")
    public void encryptPassword() {

    }

    @UseCase(id = 3, description = "decrypt password")
    public void decryptPassword() {

    }

    public static void main(String[] args) {
        // annotation processor
        List<Integer> useCases = new ArrayList<Integer>() {
            {
                add(2);
                add(3);
                add(4);
            }
        };
        checkUseCases(useCases, PasswordUtils.class);
    }

    public static void checkUseCases(List<Integer> useCaseId, Class<?> cl) {

        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("found UseCase " + uc.id() + ", description: " + uc.description());
                useCaseId.remove(new Integer(uc.id()));
            }
        }

        for (int i : useCaseId) {
            System.out.println("Warning missing UseCase " + i);
        }

    }
}
