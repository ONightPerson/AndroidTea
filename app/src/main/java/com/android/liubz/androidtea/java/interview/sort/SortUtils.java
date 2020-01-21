package com.android.liubz.androidtea.java.interview.sort;

import java.util.Arrays;

public class SortUtils {

    public static void main(String[] args) {
//        bubbleSort(new int[] {5, 8, 9, 3, 6});
//        selectionSort(new int[] {5, 8, 9, 3, 6});
//        quickSort(new int[] {5, 8, 9, 3, 6});
//        insertionSort(new int[] {5, 8, 9, 3, 6});
//        shellSort(new int[] {5, 8, 9, 3, 6});
        mergeSort(new int[] {5, 8, 9, 3, 6});
    }

    /**
     * 冒泡，降序排列
     * @param input
     */
    public static void bubbleSort(int[] input) {
        if (input == null) {
            return;
        }

        int len = input.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len-i-1; j++) {
                if (input[j] < input[j+1]) {
                    int tmp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = tmp;
                }
            }
        }
        output(input);
    }

    /**
     * 选择排序，降序排列
     * @param input
     */
    public static void selectionSort(int[] input) {
        if (input == null) {
            return;
        }
        int len = input.length;
        for (int i = 0; i < len; i++) {
            int max = input[i];
            int maxIndex = i;
            for (int j = i+1; j < len; j++) {
                if (max < input[j]) {
                    max = input[j];
                    maxIndex = j;
                }
            }
            if (i != maxIndex) {
                int tmp = input[maxIndex];
                input[maxIndex] = input[i];
                input[i] = tmp;
            }
        }
        output(input);
    }

    /**
     * 快速排序，降序排列
     * @param arr
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }

        doQuickSort(arr, 0, arr.length - 1);
        output(arr);
    }

    private static void doQuickSort(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        int pivot = arr[low];
        while (i < j) {
            while (i < j && arr[j] < pivot) {
                j--;
            }
            while (i < j && arr[i] > pivot) {
                i++;
            }
            if (arr[i] == arr[j] && i < j) {
                i++;
            } else {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        if (i - 1 > low) {
            doQuickSort(arr, 0, i - 1);
        }
        if (j + 1 < high) {
            doQuickSort(arr, j + 1, high);
        }
    }

    /**
     * 插入排序，降序排列
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        if (arr == null) {
            return;
        }
        int len = arr.length;
        if (len < 1) {
            return;
        }
        for (int i = 1; i < len; i++) {
            int cur = arr[i];
            int j = i;
            // 此处，需要注意，如果条件不满足，必须立即停止，否则会过度执行，导致赋值错误
            while (j > 0 && cur > arr[j-1]) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = cur;
            System.out.println("i = " + i);
            output(arr);
        }
        output(arr);
    }

    /**
     * 希尔排序，降序排列
     * @param arr
     */
    public static void shellSort(int[] arr) {
        if (arr == null) {
            return;
        }
        int len = arr.length;
        int gap = arr.length;
        while ((gap /= 2) > 0) {
            for (int i = 0; i < gap; i += 1) {
                for (int j = i + gap; j < len; j += gap) {
                    int k = j; // 待插入位置
                    int cur = arr[j]; // 记录待插入值
                    // 此处注意，比较 cur vs arr[k-gap]
                    while (k > i && cur > arr[k - gap]) {
                        arr[k] = arr[k - gap];
                        k -= gap;
                    }
                    arr[k] = cur;
                }
            }
        }
        output(arr);
    }

    /**
     * 归并排序，降序排列
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        int[] result = doMergeSort(arr, 0, arr.length - 1);
        output(result);
    }

    private static int[] doMergeSort(int[] arr, int low, int high) {
        if (low == high) {
            return new int[] {arr[low]};
        }
        int mid = low + (high - low) / 2;
        int[] left = doMergeSort(arr, low, mid);
        int[] right = doMergeSort(arr, mid+1, high);
        int[] newArr = new int[left.length + right.length];

        int m = 0, i = 0, j = 0;
        while (i < left.length && j < right.length) {
            newArr[m++] = left[i] < right[j] ? right[j++] : left[i++];
        }
        while (i < left.length) {
            newArr[m++] = left[i++];
        }
        while (j < right.length) {
            newArr[m++] = right[j++];
        }
        return newArr;
    }

    private static void output(int[]  input) {
        System.out.println(Arrays.toString(input));
    }
}
