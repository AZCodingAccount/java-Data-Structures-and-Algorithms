package com.zh.job.dp.stock;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-26 09:19
 * @description: 买卖股票的最佳时机2—lc122
 **/
public class MaxProfit2 {
     /*
            股票问题2也是可以贪心解决的，跟1区别在于可以买卖多次了，因此买入股票的第i天买入股票递推式变了
        dp[i][0]代表第i天买入股票的最大利润，dp[i][1]代表第i天卖出股票的最大利润。买入股票不代表当天买入，卖出股票不代表当天卖出

        dp[i][0]=max(dp[i-1][0],dp[i-1][1]-price[i]) 第i-1天买入了股票并没有卖出和第i天买入股票取一个最大值
        （为什么不能再加上第i天卖出再买入？很简单的道理，第i天卖出再买入不是收益为0吗？没有意义，卖出股票也是同理）
        dp[i][1]=max(dp[i-1][1],dp[i-1][0]+price[i])  第i-1天卖出了股票和第第i天卖出了股票取一个最大值
        （注意，如果想要第i天有的卖，第i-1天必须持有。）
        （可以多次买卖，因此买入股票的时候，可能之间交易已经获取了利润，而不是像买卖股票1是0）

        dp[0][0]=-price[0] dp[0][1]=0

        遍历顺序从前往后一次遍历即可
     */

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        dp[0][0] = -prices[0];  // 第1天买入的最大利润，必须在第一天就进行买入，因此为-price[0]
        dp[0][1] = 0;   // 第1天卖出的最大利润。可以理解为买入再卖出，为0；
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }
}
