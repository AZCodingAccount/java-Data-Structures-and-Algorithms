package com.zh.hot.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-04 16:21
 * @description: 下一个排列
 **/
public class NextPermutation {
    /*
        一个模版题，只能从这个数组取元素，问大于当前数的最小值。
        2, 6, 3, 5, 4, 1  思路是
        1：从后往前遍历，直到找到第一个递减的元素，这样可以改变的数更小，
        2：跟后面大于它且最接近的的交换
        3：交换以后，把后面的元素再逆序排列，因此最小
     */
    public void nextPermutation(int[] nums) {
        int right = nums.length - 1;
        // 1: 找到第一个递减的元素
        while (right > 0 && nums[right - 1] >= nums[right]) right--;
        // 如果找到，找到的元素索引是right-1，找不到right=0停下
        if (right == 0) {   // 对应的 3 2 1这种情况
            reverse(nums, 0, nums.length - 1);
        } else {
            // 2: 找到最接近它的元素，易知right-1后面的元素是单调递减的
            int j = nums.length - 1;
            while (nums[j] <= nums[right - 1]) j--;
            swap(nums, right - 1, j);     // 2: 交换两个元素
            reverse(nums, right, nums.length - 1);  // 3: 反转后面的数组
        }
    }

    // 交换数组元素
    private void swap(int[] nums, int num1, int num2) {
        int temp = nums[num1];
        nums[num1] = nums[num2];
        nums[num2] = temp;
    }

    // 反转数组，左闭右闭
    private void reverse(int[] nums, int left, int right) {
        // 循环或双指针反转
        for (int i = left; i < (right + left + 1) / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i + left - 1];
            nums[nums.length - i + left - 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
