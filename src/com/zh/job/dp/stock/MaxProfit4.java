package com.zh.job.dp.stock;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-26 10:33
 * @description: 买卖股票的最佳时机4—lc188
 **/
public class MaxProfit4 {
    /*
        最多买卖k轮，就是之前的2变成了k，递推公式都没变，转化成三维DP或者二维都行
        初始化dp=[prices.length][2*k+1]

        dp[i][3]=max(dp[i-1][3],dp[i-1][2]-prices[i])
        dp[i][4]=max(dp[i-1][4],dp[i-1][3]+prices[i])

        dp[0][1]    dp[0][2]    dp[0][3]    ... dp[0][2*k]  奇数初始化成-prices[i]    偶数初始化成0
     */
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][2 * k + 1];

        // 兼顾初始化和正常遍历
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j < 2 * k + 1; j++) {
                if (j % 2 != 0) {
                    if (i == 0) dp[i][j] = -prices[i];
                    else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                } else {
                    if (i == 0) dp[i][j] = 0;
                    else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
            }
        }
        return dp[prices.length - 1][2 * k];    // 最大值一定是最后一个
    }
}
