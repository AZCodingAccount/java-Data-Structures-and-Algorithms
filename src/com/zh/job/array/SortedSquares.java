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
            利用题目有序条件双指针，找到非0元素，分别平方，合并两个有序数组，中间开花
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

        // 1 2 3 4
        // 考虑全是负数的情况，barrier=0（如果全是正数，就反过来了，程序可以正常处理，所以需要加上一个判断排除全是正数的情况）
        if (barrier == 0 && nums[0] < 0) {
            barrier = nums.length;
        }
        // 处理数组
        for (int i = 0; i < length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        int left = barrier - 1;
        int right = barrier;
        int j = 0;    // 新指针
        while (left >= 0 || right <= nums.length - 1) {
            // 左边走到头了
            if (left < 0) {
                arr[j] = nums[right];
                right++;
                j++;
                continue;
            }
            // 右边走到头了
            if (right > nums.length - 1) {
                arr[j] = nums[left];
                left--;
                j++;
                continue;
            }
            // 正常，两边都没走到头
            if (nums[left] > nums[right]) {
                arr[j] = nums[right];
                right++;
            } else {
                arr[j] = nums[left];
                left--;
            }
            j++;
            //  left  right
            // [2,1,0,9,16]
            // [0,1,2,] left=-1,right=3
            //

        }
        return arr;
    }
}
