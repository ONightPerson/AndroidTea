package com.liubz.androidtea.cherish.algorithm.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    /**
     * 1 4 9 6 3
     * 1 3 9 6 4
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        while (low < high) {
            while(low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];
            while(low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high];
        }
        arr[high] = pivot;
        return high;
    }
}
