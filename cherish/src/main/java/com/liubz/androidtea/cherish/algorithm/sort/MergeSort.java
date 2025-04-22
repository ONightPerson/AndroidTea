package com.liubz.androidtea.cherish.algorithm.sort;

/**
 * 递推公式：
 * mergeSort(l...r) = merge(mergeSort(l...mid), mergeSort(mid+1...r))
 * 终止条件：l >= r;
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4, 9, 16};
        mergeSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    static void mergeSort(int[] arr, int l, int r, int[] temp) {
        if (l < r) {
            int mid = l + ((r - l) >> 1);
            mergeSort(arr, l, mid, temp);
            mergeSort(arr, mid + 1, r, temp);
            merge(arr, l, mid, r, temp);
        }
    }


    static void merge(int[] arr, int l, int mid, int r, int[] temp) {
        int i = l; // 左子数组的起始索引
        int j = mid + 1; // 右子数组的起始索引
        int t = 0; // 临时数组索引

        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        // 将左子数组剩余元素放入临时数组
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        // 将右子数组的剩余元素放入临时数组
        while (j <= r) {
            temp[t++] = arr[j++];
        }
        t = 0;
        while (l <= r) {
            arr[l++] = temp[t++];
        }
    }
}
