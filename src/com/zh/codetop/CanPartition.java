package com.zh.codetop;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-12-13 00:21
 * @description:
 **/
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;

        // 0——1背包问题，是否能装满这个背包
        int capacity = sum / 2;
        int[] dp = new int[capacity + 1];   // dp[i]代表求的和
        for (int num : nums) {
            for (int j = capacity; j >= num; j--) {
                if (dp[j] == capacity) return true;
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }
        return false;
    }
}
