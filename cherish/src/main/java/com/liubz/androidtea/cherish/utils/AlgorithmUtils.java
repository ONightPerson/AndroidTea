package com.liubz.androidtea.cherish.utils;

public class AlgorithmUtils {
    public static void swap(int [] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
