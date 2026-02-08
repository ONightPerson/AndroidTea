package com.liubz.androidtea.cherish.algorithm.sort;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4};
        insertionSort1(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * 1 2
     * @param arr
     */
    static void insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // 1
            int j = i - 1; // 已排序部分的最后一个索引
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void insertionSort1(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // 待排序
            int j = i - 1; // 已排序的最后一个
            while (j >= 0 && arr[j + 1] < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
