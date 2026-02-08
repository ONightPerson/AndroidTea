package com.liubz.androidtea.cherish.algorithm.sort;

import com.liubz.androidtea.cherish.utils.AlgorithmUtils;

import java.util.Random;

/**
 * 快速排序优化版
 * 
 * 核心思想：分治法 (Divide and Conquer)
 * 1. 挑选基准值：从数列中挑出一个元素，称为 "基准" (pivot)。
 * 2. 分割 (Partition)：重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的摆在基准后面。
 * 3. 递归排序：递归地将小于基准值元素的子数列和大于基准值元素的子数列排序。
 * 
 * 优化点：
 * 1. 随机选取基准值：防止在处理已排序序列时退化为 O(n^2)。
 * 2. 挖坑法：通过填坑的操作减少了元素交换的次数，逻辑更清晰。
 */
public class QuickSort {
    /** 用于随机选取基准值的随机数生成器 */
    private final static Random RANDOM = new Random();

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4, 10, 8, 7};
        quickSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * 快速排序入口
     * @param arr 待排序数组
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 递归执行快速排序
     * @param arr 待排序数组
     * @param low 排序范围的左边界
     * @param high 排序范围的右边界
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 通过分区操作获取基准值的最终位置
            int pivotIndex = partition(arr, low, high);
            // 递归排序基准值左侧的数据
            quickSort(arr, low, pivotIndex - 1);
            // 递归排序基准值右侧的数据
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /**
     * 分区逻辑：采用“挖坑法”
     * 
     * @param arr  待排序数组
     * @param low  当前分区的起始索引
     * @param high 当前分区的结束索引
     * @return 基准值最终停留的索引位置
     */
    public static int partition(int[] arr, int low, int high) {
        // --- 随机基准优化 ---
        // 生成 [low, high] 范围内的随机索引
        int randomIndex = low + RANDOM.nextInt(high - low + 1);
        // 将随机选中的基准值交换到左端点
        AlgorithmUtils.swap(arr, randomIndex, low);
        
        // --- 挖坑法开始 ---
        // 将基准值“挖出”存入变量中，此时 low 位置形成一个“坑”
        int pivot = arr[low];
        
        while (low < high) {
            // 坑在左边，从右向左寻找第一个比基准值小的数
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            // 找到小的数后，将其填入左边的坑中，此时右边 high 位置形成新坑
            arr[low] = arr[high];
            
            // 坑在右边，从左向右寻找第一个比基准值大的数
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            // 找到大的数后，将其填入右边的坑中，此时左边 low 位置形成新坑
            arr[high] = arr[low];
        }
        
        // 当指针碰撞（low == high）时，将最初取出的基准值填回最后的坑位
        arr[low] = pivot;
        // 返回基准值所在的最终索引
        return low;
    }

}
