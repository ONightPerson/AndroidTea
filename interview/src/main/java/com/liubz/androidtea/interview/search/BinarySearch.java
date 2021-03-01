package com.liubz.androidtea.interview.search;

/**
 * author: created by liubaozhu on 2021/3/1
 * email: liubaozhu@baidu.com
 */
public class BinarySearch {

    /**
     * 二分查找
     * @param a 目标数组
     * @param target 目标数
     * @return 目标值所在数组的索引 -1 表示数组中无该值
     */
    public static int binarySearch(int[] a, int target) {
        if (a == null) {
            return -1;
        }
        return doBinarySearch(a, target, 0, a.length);
    }

    private static int doBinarySearch(int[] a, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >>> 1);
        System.out.println("mid: " + mid);
        if (a[mid] == target) {
            return mid;
        } else if (a[mid] < target) {
            return doBinarySearch(a, target, mid + 1, high);
        } else {
            return doBinarySearch(a, target, low, mid - 1);
        }
    }

    /**
     * 数组 a 为旋转数组（把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组旋转
     * @param a
     * @return
     */
    public static int getMinOfRotateArray(int[] a) throws Exception {
        if (a == null) {
            throw new Exception("invalid params");
        }
        int low = 0;
        int high = a.length - 1;
        int mid = low;
        while (a[low] >= a[high]) {
            if (high - low == 1) {
                mid = high;
                break;
            }
            mid = low + ((high - low) >>> 1);
            // 特殊情况，首尾和中间位置均相等，无法判断最小值在前面还是后面
            if (a[low] == a[high] && a[mid] == a[low]) {
                return getMinByTraverseAll(a, low, high);
            }
            if (a[mid] >= a[low]) {
                low = mid;
            } else if (a[mid] <= a[high]) {
                high = mid;
            }
        }
        return a[mid];
    }

    private static int getMinByTraverseAll(int[] a, int low, int high) {
        int sentinel = a[low];
        for (int i = low + 1; i <= high; i++) {
            if (sentinel < a[i]) {
                sentinel = a[i];
            }
        }
        return sentinel;
    }

    public static void main(String[] args) throws Exception {
        int[] a = {6, 9, 12, 15, 81, 99, 1, 2, 3};
//        int index = binarySearch(a, 4);
//        System.out.println("index: " + index);

        int min = getMinOfRotateArray(a);
        System.out.println("min: " + min);
    }


}
