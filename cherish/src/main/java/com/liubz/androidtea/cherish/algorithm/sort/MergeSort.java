package com.liubz.androidtea.cherish.algorithm.sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4};
        mergeSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
    }
}
