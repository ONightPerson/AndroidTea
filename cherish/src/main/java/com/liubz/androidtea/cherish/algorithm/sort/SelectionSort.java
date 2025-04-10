package com.liubz.androidtea.cherish.algorithm.sort;

import com.liubz.androidtea.cherish.utils.AlgorithmUtils;

/**
 * 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4};
        selectionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int largest = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[largest]) {
                    largest = j;
                }
            }
            if (largest != i) {
                AlgorithmUtils.swap(arr, largest, i);
            }
        }
    }
}
