package com.zh.algorithm.dp;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-10 21:24
 * @description: 零钱兑换问题—leetcode103题
 **/
public class CoinChange {
    /*
        给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
        如果没有任何一种硬币组合能组成总金额，返回 -1。
        跟完全背包问题类似（但是注意：必须总量一样），总金额是背包容量、不同硬币面额是不同物品、求的硬币组合的最小个数类似与背包的最大价值（硬币组合跟完全背包的不同物品组合）
            递推式
            if(装不下){
             组合的最小个数继承前一些面额的硬币   dp[i][j]=dp[i-1][j]
            }else{
                // 假设加上这个面额的硬币跟上一个硬币个数的最小值
                dp[i][j]=min(dp[i-1][j],dp[i][j-item.weight]+1)
            }
     */

    public int coinChange(int[] coins, int amount) {
        // 2  3
        int[][] dp = new int[coins.length][amount + 1]; // 初始化状态数组
        int label = 1_000_000;  // 大于题目的account即可，题目是10^4
        // 初始化第一行 —— 为了兼容装不下的情况
        for (int i = 1; i < dp[0].length; i++) {
            if (i % coins[0] == 0) {    // 初始化第0行第i列
                dp[0][i] = i / coins[0];
            } else {
                // 其他情况说明不满足组成总金额条件，标记为label
                dp[0][i] = label;
            }
        }

        // 开始dp
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < amount + 1; j++) {  // 总金额
                if (j < coins[i]) {     // 硬币比总金额还大
                    dp[i][j] = dp[i - 1][j];
                } else {  // 硬币小于总金额
                    dp[i][j] = Integer.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
                }
            }
        }
        return dp[coins.length - 1][amount] == label ? -1 : dp[coins.length - 1][amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        System.out.println(new CoinChange().coinChange(coins, amount));
    }

}
