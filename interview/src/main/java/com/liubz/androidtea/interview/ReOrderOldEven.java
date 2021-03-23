package com.liubz.androidtea.interview;

/**
 * author: created by liubaozhu on 2021/3/5
 * email: liubaozhu@baidu.com
 */
public class ReOrderOldEven {

    public static void reorderOldEven(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            while (low < high && !isEven(arr[low])) {
                low++;
            }
            while (low < high && isEven(arr[high])) {
                high--;
            }
            if (low < high) {
                int tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;
                low++;
                high--;
            }
        }
    }

    private static boolean isEven(int number) {
        return (number & 1) == 0;
    }

    private static void printArr(int[] arr) {
        for (int number : arr) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 5, 2, 3, 2, 7, 19, 8};
        reorderOldEven(arr);
        printArr(arr);
    }
}
