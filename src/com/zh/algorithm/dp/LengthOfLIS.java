package com.zh.algorithm.dp;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-12 16:09
 * @description: 最长递增子序列——leetcode300题
 **/
public class LengthOfLIS {
    /*
            给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
            子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的
        子序列。
        0   1   2   3   4
      0 1
      1     2
      2         3
      3             4
      4                 5
       本质也是二维数组、假设前3个元素，那么需要考虑第1、第2两个元素，类似于三角形的数组
       （不能是矩形，举个例子，你能考虑前5个元素，第3个元素的最长递增子序列的长度吗？没有意义）
       递推式 dp[i][j]第i个元素，考虑前j个元素的最长严格递增子序列的长度
       if(nums[i]>nums[i-1]){
            // 说明可以递增了
            dp[i][j]=dp[i-1][j-1]+1
       }


       学迷糊了，优化到最后忽然发现根据不需要二维数组......，遍历一下就可以了
     */

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length + 1][length + 1]; // 第一行第一列没有实际意义

        for (int[] ints : dp) {
            Arrays.fill(ints, 1);
        }
        for (int i = 2; i < length + 1; i++) {
            for (int j = 2; j <= i; j++) {
                if (nums[i - 1] > nums[j - 2]) {
                    dp[i][i] = Math.max(dp[j - 1][j - 1] + 1, dp[i][i]);
                }
            }
        }
        return Arrays.stream(dp).flatMapToInt(Arrays::stream).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new LengthOfLIS().lengthOfLIS(nums));
    }
}
