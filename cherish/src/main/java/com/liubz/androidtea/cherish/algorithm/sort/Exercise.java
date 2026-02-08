package com.liubz.androidtea.cherish.algorithm.sort;

import com.liubz.androidtea.cherish.utils.AlgorithmUtils;

public class Exercise {
    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 5, 12, 4, 8, 2};
        quickSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int low, int high) {
        // 优化：小数组使用插入排序 (此处演示略，保留快排核心)
        if (low >= high) {
            return;
        }
        int pivotIndex = partition(arr, low, high);
        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }

    /**
     * 采用“挖坑法”实现分区
     */
    public static int partition(int[] arr, int low, int high) {
        // 优化：随机选择一个索引与 low 交换，作为基准点，防止最坏情况
        // int randomIndex = low + new java.util.Random().nextInt(high - low + 1);
        // AlgorithmUtils.swap(arr, low, randomIndex);

        int pivot = arr[low]; // 取第一个元素为基准，将其“挖出”
        while (low < high) {
            // 从右向左找第一个比基准小的数
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            // 填入左边的坑，右边形成新坑
            arr[low] = arr[high];

            // 从左向右找第一个比基准大的数
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            // 填入右边的坑，左边形成新坑
            arr[high] = arr[low];
        }
        // 最后将基准值填入最后的坑位
        arr[low] = pivot;
        return low; // 返回基准值的最终位置
    }
}
