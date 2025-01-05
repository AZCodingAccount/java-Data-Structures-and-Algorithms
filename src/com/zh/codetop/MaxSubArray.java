package com.zh.codetop;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-12 01:22
 * @description: 最大子数组和
 **/
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE, preSum = 0;
        for (int num : nums) {
            res = Math.max(res, preSum + num);
            preSum += num;
            if (preSum < 0) preSum = 0;
        }
        return res;
    }
}
