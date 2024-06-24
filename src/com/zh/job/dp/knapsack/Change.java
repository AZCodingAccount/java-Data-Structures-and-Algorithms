package com.zh.job.dp.knapsack;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-24 15:08
 * @description: 零钱兑换2—lc518
 **/
public class Change {
    /*
        这次使用一维DP解这道题，一个完全背包问题，coins是物品，amount是物品总和，价值用硬币值代替
        dp[j]代表可以凑成总金额为j的物品总数
        dp[j]=dp[j]+dp[j-nums[i]]
        dp[0]=1，其他为0,dp[amount+1]
        遍历顺序还是两层for循环，但是这次内层for循环正向遍历，不需要依赖上次的结果，并且是完全背包
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coin];
            }
        }
        return dp[amount];
    }
}
