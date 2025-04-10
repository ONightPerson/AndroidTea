package com.liubz.androidtea.cherish.algorithm.sort;

import com.liubz.androidtea.cherish.utils.AlgorithmUtils;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 9, 3, 2, 1};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int n = arr.length;
        boolean swapped;
        for (int i = n - 1; i >= 0; i--) {
            swapped = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    AlgorithmUtils.swap(arr, j, j + 1);
                    swapped = true; // 优化版冒泡排序
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
