package com.zh.algorithm.binarysearch;

public class BinarySearch {
    // 1. 二分查找
    /*
     * 传递两个参数，待查找的数组，需要查找的数字
     * 返回一个参数，待查找数字的索引，未查找到返回-1
     * */
    public static int binarySearchBase(int[] arr, int num) {
        int i = 0, j = arr.length - 1;        // 定义指针
        while (i <= j) {
            int middle_index = (i + j) / 2; // 求出i和j中间的值
            if (num > arr[middle_index]) {
                i = middle_index + 1; // 改变i的指针
            } else if (num < arr[middle_index]) {
                j = middle_index - 1; // 改变j的指针
            } else {
                return middle_index;
            }
        }
        return -1;

    }

    /*
     * 2. 这个函数查找的是最左边的匹配的元素索引
     * */
    public static int leftMostBinarySearch(int[] arr, int target) {
        //[2,4,6,6,6,8,9]   6 5
        // m=3 i=0 j=2
        // m=1 i=1 j=2
        // m=1 i=2 j=2
        // m=2 i=2 j=1
        int i = 0, j = arr.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = i + j >>> 1;
            if (target > arr[m]) {
                i = m + 1;
            } else if (target < arr[m]) {
                j = m - 1;
            } else {
                candidate = m;
                j = m - 1;
            }
        }
        return candidate;
    }

    /*
     * 3. 这个函数查找的是最右边的匹配的元素索引
     * */
    public static int rightMostBinarySearch(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = i + j >>> 1;
            if (target > arr[m]) {
                i = m + 1;
            } else if (target < arr[m]) {
                j = m - 1;
            } else {
                candidate = m;
                i = m + 1;
            }
        }
        return candidate;
    }

    /*
     * 4. 这个函数完成的功能是返回这个数应该插入的索引，有重复元素的情况
     * */
    public static int returnInsertIndexBinarySearch1(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = i + j >>> 1;
            if (target > arr[m]) {
                i = m + 1;
            } else if (target < arr[m]) {
                j = m - 1;
            } else {
                candidate = m;
                j = m - 1;
            }
        }
        if (candidate == -1) {
            return i;
        } else {
            return candidate;
        }
    }

    /*
     * 5. 这个函数完成的功能是返回这个数应该插入的索引，没有重复元素的情况
     * */
    public static int returnInsertIndexBinarySearch2(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int m = i + j >>> 1;
            if (target > arr[m]) {
                i = m + 1;
            } else if (target < arr[m]) {
                j = m - 1;
            } else {
                return m;
            }
        }
        return i;
    }

}
