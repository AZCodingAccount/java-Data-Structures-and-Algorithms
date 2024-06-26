package com.zh.job.dp.stock;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-25 20:27
 * @description: 买卖股票的最佳时机1—lc121
 **/
public class MaxProfit {
    /*
            这道题可以使用一个minPrice一次遍历，然后遍历过程中不断更新最大值解决，但是股票系列问题都可以通过dp解决，这里使用dp
        dp[i][0]代表第i天买入股票的最大利润，dp[i][1]代表第i天卖出股票的最大利润。买入股票不代表当天买入，卖出股票不代表当天卖出
        dp[i][0]=max(dp[i-1][0],dp[i-1][1]-price[i]) 第i-1天买入了股票并没有卖出和第i天买入股票取一个最大值
        dp[i][1]=max(dp[i-1][1],dp[i-1][0]+price[i])  第i-1天卖出了股票和第第i天卖出了股票取一个最大值
        （注意，如果想要第i天有的卖，第i-1天必须持有。）
        （为什么第i天买入不要求第i-1天卖出呢？只能买卖一次，即前面状态不准卖。就是买入股票的最大利润就是当前状态下尽量买个少点的股票）
        dp[0][0]=-price[0] dp[0][1]=0
        遍历顺序从前往后一次遍历即可
     */

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }
}
