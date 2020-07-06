package com.liubz.androidtea.interview;


import java.util.Arrays;

/**
 * Created by liubaozhu on 2020-01-04
 */
public class GoldProblem {

    public static void main(String[] args) {
//        Pair<Integer, Integer> result = getMinMaxWeights(new int[]{333, 4, 3, 232, 563, 89});
//        System.out.println(result);
        String a = "sslbd";
        String b = "lbd";
        System.out.println(a.indexOf(b));

        System.out.println(null + "fefe");
    }



    public static Pair<Integer, Integer> getMinMaxValue(int[] value) {
        if (value == null || value.length == 0) {
            return null;
        }
        int max = value[0];
        int min = value[1];
        for (int i = 1; i < value.length; i++) {
            if (max < value[i]) {
                max = value[i];
            }
            if (min > value[i]) {
                min = value[i];
            }
        }
        return new Pair<>(max, min);
    }

    public static Pair<Integer, Integer> getMinMaxWeights(int[] weights) {
        if (weights == null || weights.length == 0) {
            return null;
        }
        int n = weights.length;
        int max;
        int min;
        if (n == 1) {
            max = min = weights[0];
            return new Pair<>(max, min);
        } else if (n == 2) {
            if (weights[0] > weights[1]) {
                max = weights[0];
                min = weights[1];
            } else {
                max = weights[1];
                min = weights[0];
            }
            return new Pair<>(max, min);
        }
        int border = n / 2;
        int[] left = Arrays.copyOf(weights, border);
        int[] right = Arrays.copyOfRange(weights, border, n);
        Pair<Integer, Integer> leftResult = getMinMaxWeights(left);
        Pair<Integer, Integer> rightResult = getMinMaxWeights(right);
        max = leftResult.first > rightResult.first ? leftResult.first : rightResult.first;
        min = leftResult.second < rightResult.second ? leftResult.second : rightResult.second;
        return new Pair<>(max, min);
    }
}
