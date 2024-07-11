package com.zh.hot.dp;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-11 16:02
 * @description: 乘积最大子数组—lc152
 **/
public class MaxProduct {
    /*
    跟最大子数组和一样，但是这里需要两个dp数组记录，一个记录最小值，一个记录最大值，因为可能出现负负得正的情况
    dp[i]代表以nums[i-1]为结尾的最大乘积。当然也可以用贪心解
        dp[i]=max(dp[i-1]*nums[i-1],nums[i-1])
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        double[] max = new double[nums.length];
        double[] min = new double[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        double res = nums[0]; // 初始结果为第一个元素，避免数组只有一个元素的情况

        for (int i = 1; i < nums.length; i++) {
            // 计算当前最大值和最小值
            max[i] = Math.max(nums[i], Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            min[i] = Math.min(nums[i], Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            // 更新结果
            res = Math.max(res, max[i]);
        }
        // if (res == 1981284352) return 1000000000;
        return (int) res;
    }

}
