package com.zh.job.dp;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-22 21:36
 * @description: 最后一块石头的重量—lc1049
 **/
public class LastStoneWeightII {
    /*
            0—1背包问题，跟你能不能分成子集变成了相距最小的两个子数组。别问我为什么能转化成0—1背包，问就是背的。
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int capacity = sum / 2;
        int[] dp = new int[capacity + 1];

        for (int num : stones) {  // 外层是物品，元素个数
            for (int j = capacity; j >= num; j--) { // 内层是背包容量
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }
        // 最后求出的dp[capacity]就是最靠近中间的答对容量，sum-2*dp[i]即可，就是让这两堆撞一下，剩下的就是最后一块石头的重量
        return sum - 2 * dp[capacity];
    }
}
