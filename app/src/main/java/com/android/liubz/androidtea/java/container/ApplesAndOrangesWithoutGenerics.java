package com.android.liubz.androidtea.java.container;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by liubaozhu on 2019-12-18
 */
public class ApplesAndOrangesWithoutGenerics {

    public static void main(String[] args) {

        Collection<Integer> result = new ArrayList<>(Arrays.asList(1, 34, 2));
        Integer[] otherScores = new Integer[] {1, 3, 9};
        Collections.addAll(result, otherScores);
        for (int number : result) {
            System.out.println(number);
        }

        List<Plant> plants = Arrays.asList(new Apple(), new Orange());
    }

    static class Plant {}
    static class Fruit extends Plant {}
    static class Apple extends Fruit {}
    static class Orange extends Fruit {}
    static class Vegetable extends Plant {}
}
