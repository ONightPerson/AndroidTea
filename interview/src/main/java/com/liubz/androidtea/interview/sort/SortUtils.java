package com.liubz.androidtea.interview.sort;

import java.util.Arrays;

public class SortUtils {

    private static final int KEY = 171;

    private static final String SYSTEM_GET_SYSINFO = "\"system\":{\"get_sysinfo\":{}}";
    private static final String GET_SYSINFO = "{" + SYSTEM_GET_SYSINFO + "}";

    private static final String pjlink_DISCOVERY_MSG = "2532535243480d";

    private static final String ONKYO_DISCOVERY_MSG = "49534350000000100000000901000000217845434e5153544e";
    public static void main(String[] args) {
//        bubbleSort(new int[] {5, 8, 9, 3, 6});
//        selectionSort(new int[] {5, 8, 9, 3, 6});
        quickSort(new int[] {7, 15, 13, 8, 4, 2, 8, 17, 6, 3});
//        insertionSort(new int[] {5, 8, 9, 3, 6});
//        shellSort(new int[] {5, 8, 9, 3, 6});
//        mergeSort(new int[] {5, 8, 9, 3, 6});
//        heapSort(new int[] {5, 8, 9, 3, 6});
//        countingSort(new int[] {5, 8, 9, -3, 6});
//        bucketSort(new int[] {5, 8, 9, -3, 6}, 3);
//        radixSort(new int[] {818, 954, 672, 826, 981}, 3);
//        test();
        test1();
    }

    public static void test1() {
        String st1 = "ab";
        String st2 = "abc";
        String st3 = st1 + "c";
        System.out.println(st2 == st3);
        System.out.println(st2.equals(st3));
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    /**
     * Encrypts the string into a byte array.
     *
     * @param string String to encrypt
     * @return byte array with encrypted string
     */
    public static byte[] encrypt(String string) {
        byte[] buffer = new byte[string.length()];
        byte key = (byte) KEY;
        for (int i = 0; i < string.length(); i++) {
            buffer[i] = (byte) (string.charAt(i) ^ key);
            key = buffer[i];
        }
        return buffer;
    }

    private static void test() {
        String s = " ";
        System.out.println("char:" + (s.charAt(0) - 0) + "fefe");

        String[][] DICT =  {{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            {"", "M", "MM", "MMM"}};
        System.out.println(DICT[3][3]);
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
            System.out.println("i: " + i + ", j: " + j);
            if (arr[i] == arr[j] && i < j) {
                i++;
            } else {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        System.out.println("i - 1: " + (i - 1) + ", low: " + low + ", j + 1： " + (j + 1) + ", high: " + high);
        if (i - 1 > low) {
            doQuickSort(arr, low, i - 1);
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
        if (arr == null || arr.length < 2) {
            return;
        }
        int len = arr.length;
        // 遍历未排序的数据下标
        for (int i = 1; i < len; i++) {
            int cur = arr[i];
            int j = i;
            // 与已排序的数据进行比较，注意临界点
            while (j > 0 && cur > arr[j-1]) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = cur;
        }
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
        doMergeSort(arr, 0, arr.length - 1);
        output(arr);
    }

    private static void doMergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) >> 1;
        doMergeSort(arr, low, mid);
        doMergeSort(arr, mid+1, high);

        int i = low;
        int j = mid + 1;
        int k = 0;
        int num = high - low + 1;
        int[] tmp = new int[num];

        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= high) {
            tmp[k++] = arr[j++];
        }


        for (int m = 0; m < num; m++) {
            arr[low++] = tmp[m];
        }
    }

    /**
     * 向下堆化（大顶堆）
     * @param arr
     * @param index 当前待堆化的节点
     * @param len 堆节点个数
     */
    private static void siftDown(int [] arr, int index, int len) {
        int item = arr[index]; // 当前待堆化的节点值
        for (int i = 2 * index + 1; i < len; i = 2 * i + 1) {
            if (i + 1 < len && arr[i] < arr[i + 1]) {
                i++;
            }
            // 当前i为子节点较大的节点，若当前节点大于子节点，则堆化完成
            if (item >= arr[i]) {
                break;
            }
            arr[index] = arr[i];
            index = i; // 将要比较的节点转移到子节点
        }
        arr[index] = item;
    }

    public static void heapSort(int[] arr) {
        int len;
        if (arr == null || (len = arr.length) < 2) {
            return;
        }
        createHeap(arr, len);
        // i 既表示最后一个节点，又表示下次堆化的堆长度
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            siftDown(arr, 0, i);
        }
        output(arr);
    }

    private static void createHeap(int[] arr, int len) {
        int lastNoLeaf = len / 2 - 1; // 最后一个非叶子节点
        for (int i = lastNoLeaf; i >= 0; i--) {
            siftDown(arr, i, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 计数排序，降序排列
     * @param arr 原数组
     */
    public static void countingSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int[] minMax = getMinMax(arr);
        int min = minMax[0];
        int max = minMax[1];
        doCountingSort(arr, min, max);
        output(arr);
    }

    private static void doCountingSort(int[] arr, int min, int max) {
        int bucketLen = max - min + 1;
        int[] bucket = new int[bucketLen];
        for (int value : arr) {
            bucket[value - min]++;
        }

        int sortedIndex = 0;
        for (int i = bucketLen - 1; i >= 0; i--) {
            while (bucket[i] > 0) {
                arr[sortedIndex++] = i + min;
                bucket[i]--;
            }
        }
    }

    private static int[] getMinMax(int[] arr) {
        int min, max;
        min = max = arr[0];
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            if (min > arr[i]) {
                min = arr[i];
            } else if (max < arr[i]) {
                max = arr[i];
            }
        }
        return new int[] {min, max};
    }

    /**
     *
     * @param arr 待排序数组
     * @param bucketSize 桶大小
     */
    public static void bucketSort(int[] arr, int bucketSize) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int[] minMax = getMinMax(arr);
        doBucketSort(arr, bucketSize, minMax[0], minMax[1]);
        output(arr);
    }

    private static void doBucketSort(int[] arr, int bucketSize, int min, int max) {
        int bucketLen = (max - min) / bucketSize + 1; // 获取桶数量
        int[][] bucket = new int[bucketLen][0]; // 组装桶

        // 向各个桶发送数字
        for (int i = 0; i < arr.length; i++) {
            int index = (max - arr[i]) / bucketSize;
            bucket[index] = extendArr(bucket[index], arr[i]);
        }

        int startIndex = 0;
        for (int i = 0; i < bucketLen; i++) {
            int[] eleArr = bucket[i];
            if (eleArr.length <= 0) {
                continue;
            }
            insertionSort(eleArr);
            for (int j = 0; j < eleArr.length; j++) {
                arr[startIndex++] = eleArr[j];
            }
        }
    }

    private static int[] extendArr(int[] arr, int value) {
        int[] result = Arrays.copyOf(arr, arr.length + 1);
        result[arr.length] = value;
        return result;
    }

    /**
     * 基数排序
     * @param arr
     */
    public static void radixSort(int[] arr, int digit) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int total = digit;
        while (digit != 0) {
            int[][] bucket = new int[10][0];
            for (int i = 0; i < arr.length; i++) {
                int index = arr[i] / ((int) Math.pow(10, total - digit)) % 10;
                bucket[index] = extendArr(bucket[index], arr[i]);
            }


            int startIndex = 0;
            for (int i = 0; i < 10; i++) {
                int subLen = bucket[i].length;
                if (subLen <= 0) {
                    continue;
                }
                for (int j = 0; j < subLen; j++) {
                    arr[startIndex++] = bucket[i][j];
                }
            }
            digit--;
        }
        output(arr);
    }




    private static void output(int[]  input) {
        System.out.println(Arrays.toString(input));
    }
}
