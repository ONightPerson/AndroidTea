package com.liubz.androidtea.cherish.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by liubaozhu on 2021/1/17
 */
public class GenericTest {

    private Map<String, Integer> scores;

    public static void main(String[] args) throws NoSuchFieldException {
        Class<GenericTest> clazz = GenericTest.class;
        Field field = clazz.getDeclaredField("scores");
        Class<?> a = field.getType();
        System.out.println("scores的类型：" + a);
        Type gType = field.getGenericType();
        System.out.println("gType: " + gType);
        if (gType instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) gType;
            Type rType = pType.getRawType();
            System.out.println("rType: " + rType);
            // 获取泛型类型的泛型参数
            Type ownerType = pType.getOwnerType();
            System.out.println("ownerType: " + ownerType);
            Type[] tArgs = pType.getActualTypeArguments();
            System.out.println("泛型类型是: ");
            for (int i = 0; i < tArgs.length; i++) {
                System.out.println("第" + i + "个泛型类型参数类型为: " + tArgs[i]);
            }
        }
    }
}
