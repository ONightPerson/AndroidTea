package com.liubz.androidtea.cherish.algorithm.search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 2, 4, 4, 5};
//        System.out.println(binarySearch(nums, 2));
//        System.out.println(binarySearchFirst(nums, 2));
//        System.out.println(binarySearchLast(nums, 2));
//        System.out.println(binarySearchFirstGTE(nums, 2));
//        System.out.println(binarySearchLastLTE(nums, 3));

        int[] nums2 = new int[]{6, 7, 8, 1, 2, 2, 2, 4, 4, 5};
        System.out.println(binarySearchInRotatedArray(nums2, 4));
        System.out.println(binarySearchInRotatedArray(nums2, 7));
    }

    /**
     * 二分查找等于给定值的下标
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = low + ((high - low) >>> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找第一个等于给定值的下标
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchFirst(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = low + ((high - low) >>> 1);
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找最后一个等于给定值的下标
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchLast(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int n = nums.length;
        int high = n - 1;
        int mid;
        while (low <= high) {
            mid = low + ((high - low) >>> 1);
            if (nums[mid] == target) {
                if (mid == n - 1 || nums[mid + 1] != target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 二分查找第一个大于等于给定值的下标
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchFirstGTE(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = low + ((high - low) >>> 1);
            if (nums[mid] >= target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找最后一个小于等于给定值的下标
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchLastLTE(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int mid;
        while (low <= high) {
            mid = low + ((high - low) >>> 1);
            if (nums[mid] <= target) {
                if (mid == n - 1 || nums[mid + 1] > target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 在循环有序数组中二分查找
     * 8 9 10 11 12 1 2 3 4
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchInRotatedArray(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = low + ((high - low) >>> 1);
            if (nums[mid] == target) {
                return mid;
            }
            // 左半部分有序
            if (nums[mid] >= nums[low]) {
                if (target < nums[mid] && target >= nums[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // 右半部分有序
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
