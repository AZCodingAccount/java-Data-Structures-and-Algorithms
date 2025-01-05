package com.zh.codetop;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-12-01 20:52
 * @description:
 **/
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length, n = amount;
        // dp[i][j]代表最少得硬币个数
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = n + 1;
        }
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 装得下
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }
        return dp[m][n] == n + 1 ? -1 : dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1, 2, 5}, 11));
    }
}
