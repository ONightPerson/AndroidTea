package com.liubz.androidtea.cherish.algorithm.sort;

/**
 * 堆排序
 *
 *      10
 *     / \
 *   4   3
 *  /  \
 * 5   1
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {10, 4, 3, 5, 1};
        heapSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            siftDown(arr, i, 0);
        }
    }


//    static void siftDown(int[] arr, int n, int i) {
//        int largest = i;
//        int left = 2 * i + 1;
//        int right = 2 * i + 2;
//        if (left < n && arr[left] > arr[largest]) {
//            largest = left;
//        }
//        if (right < n && arr[right] > arr[largest]) {
//            largest = right;
//        }
//        if (largest != i) {
//            swap(arr, largest, i);
//            siftDown(arr, n, largest);
//        }
//
//
//    }

    static void siftDown(int[] arr, int n, int i) {
        int value = arr[i];
        int half = n >>> 1;
        while (i < half) {
            int child = 2 * i + 1;
            int right = child + 1;
            if (right < n && arr[right] > arr[child]) {
                child = right;
            }

            if (arr[i] >= arr[child]) {
                break;
            }
            arr[i] = arr[child];
            i = child;
        }
        arr[i] = value;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
