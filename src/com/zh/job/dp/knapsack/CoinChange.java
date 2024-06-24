package com.zh.job.dp.knapsack;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-24 16:42
 * @description: 零钱兑换—lc322
 **/
public class CoinChange {
    /*
        dp[j]代表凑成总金额为j的最少的硬币个数
        dp[j]=min(dp[j],dp[j-coins[i]]+1)
        dp[0]=0
        正常的完全背包遍历顺序
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 初始化
        Arrays.fill(dp, amount + 1);
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        return dp[amount]>amount?-1:dp[amount]; // 因为硬币一定是大于1的，因此正常求出的最少硬币个数应该是小于等于amount的
    }
}
