package com.zh.job.dp.stock;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-27 20:01
 * @description: 买卖股票的最佳时机含手续费—lc714
 **/
public class MaxProfit6 {
    /*
        这次加上了手续费，因此在列卖出的时候加上手续费就可以了，就不按照DP4段式列了，直接DP公式
        持有股票：            dp[i][0]=max(dp[i-1][0],dp[i-1][1]-prices[i])
        不持有股票           dp[i][1]=max(dp[i-1][0]+prices[i]-fee,dp[i-1][1])
        dp[0][0]=-prices[0]；dp[0][1]=0;(为什么是0不是-fee,带入dp[1][0]理解一下就可以了)
     */
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }

        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]); //为什么两者取最大值？可能手续费很高，卖出去亏钱
    }
}
