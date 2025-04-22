package com.liubz.androidtea.cherish.algorithm.sort;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4};
        shellSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static void shellSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += gap) {
                int temp = arr[i]; // 待排序
                int j = i - gap; // 已排序的最后索引
                while (j >= 0 && arr[j] > temp) {
                    arr[j + gap] = arr[j];
                    j -= gap; // NOTE 迭代条件
                }
                arr[j + gap] = temp;
            }
        }
    }
}
