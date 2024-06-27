package com.zh.job.dp.stock;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-27 19:31
 * @description: 买卖股票的最佳时机含冷冻期5—lc309
 **/
public class MaxProfit5 {
    /*
     求含冷冻期，即刚卖有一天不能再买入其他的，求最大利润（dp[i][1]和dp[i][3]也可以合并，一个意思）
        dp[i][0] 代表持有股票
        dp[i][1] 代表不持有股票，今天刚卖
        dp[i][2] 代表不持有股票，之前卖的
        dp[i][3] 代表处于冷冻期
      递推公式
        1：前一天持有股票、前一天处于冷冻期、前一天不持有股票
        dp[i][0]=max(dp[i-1][0],dp[i-1][3]-prices[i],dp[i-1][2]-prices[i])
        2：前一天持有股票且今天买入
        dp[i][1]=dp[i-1][0]+prices[i]
        3：继承前一天状态或冷冻期状态继承过来
        dp[i][2]=max(dp[i-1][2],dp[i-1][3])
        4：处于冷冻期，一定是前天刚卖
        dp[i][3]=dp[i-1][1]
      初始化
        dp[0][0]初始化成-prices[0]，dp[0][1]其他初始化成0
     */

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[prices.length][3];
        // 把上面的dp[i][1]和dp[i][3]合并成一个dp[i][1]
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            // 现在的dp[i][1]代表当天卖出股票，也就是下一天是冷冻期了，这个状态被包含在dp[i][2]（不持有股票，之前卖的）里面了
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        return Math.max(dp[prices.length - 1][0], Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]));
    }
}
