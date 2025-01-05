package com.zh.codetop;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-17 22:25
 * @description:
 **/
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length, res = 0;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
