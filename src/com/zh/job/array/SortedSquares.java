package com.zh.job.array;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-05-24 21:58
 * @description: 有序数组的平方—lc977
 **/
public class SortedSquares {

    /*
    暴力
     */
    public int[] sortedSquares1(int[] nums) {
        int length = nums.length;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = nums[i] * nums[i];
        }
        Arrays.sort(arr);
        return arr;
    }

    /*
            利用题目有序条件双指针，找到非0元素，分别平方，合并两个有序数组
     */
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int[] arr = new int[length];
        int barrier = 0;
        // 也可以二分找
        for (int i = 0; i < length; i++) {
            if (nums[i] >= 0) {
                barrier = i;
                break;
            }
        }
        // 处理数组
        for (int i = 0; i < length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        int left = 0;
        int right = barrier;
        int j = 0;
        while (left < barrier || right <length) {
            if (left < barrier && (nums[left] < nums[right] || right == length - 1)) {
                left++;
                arr[j++] = nums[left];
            }
            if (right < length && (nums[right] < nums[left] || left == barrier - 1)) {
                right++;
                arr[j++] = nums[right];
            }
        }
        return arr;
    }
}
