package com.liubz.androidtea.cherish.algorithm.sort;

/**
 * 计数排序
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4, 4, 5};
        countingSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void countingSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        int n = max - min + 1;
        int[] count = new int[n];

        // NOTE: 重置为0
        reset(count);
        // 统计每个元素出现的次数
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        // 累加当前元素和前面所有元素的值
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] result = new int[arr.length];
        // 倒序遍历原数组，根据count数组中的值，将元素放入result数组中
        for (int i = arr.length - 1; i >= 0; i--) {
            result[--count[arr[i] - min]] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }

    }

    public static void reset(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
    }
}
