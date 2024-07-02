package com.zh.hot.array;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-02 20:58
 * @description: 最大子数组和
 **/
public class MaxSubArray {
    public int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int maxSubArray2(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            // 前面的抛弃，重新开序列
            if (sum < 0) {
                sum = 0;
            }
            sum += num;
            res = Math.max(sum, res);
        }
        return res;
    }
}
