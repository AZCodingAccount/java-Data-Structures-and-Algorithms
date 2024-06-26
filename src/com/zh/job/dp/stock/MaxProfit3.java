package com.zh.job.dp.stock;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-26 09:58
 * @description: 买卖股票的最佳时机3—lc123
 **/
public class MaxProfit3 {
    /*
        跟买卖股票2又不一样了，这次限制了最多完成两笔交易，求最大利润，因此定义4个状态。
        dp[i][0]是什么操作都没有的状态。    可以省略成1
        dp[i][1]是第一笔交易买入（持有股票）的状态
        dp[i][2]是第一笔交易卖出（不持有股票）的状态
        dp[i][3]是第二笔交易买入（持有股票）的状态
        dp[i][4]是第二笔交易卖出（不持有股票）的状态

        dp[i][1]=max(dp[i-1][1],-prices[i])
        dp[i][2]=max(dp[i-1][2],dp[i][1]+prices[i])
        dp[i][3]=max(dp[i-1][3],dp[i-1][2]-prices[i])
        dp[i][4]=max(dp[i-1][4],dp[i-1][3]+prices[i])

        dp[i][1]=-prices[i]; dp[i][2]=0;  dp[i][3]=-prices[i]; dp[i][4]=0;
        卖出的状态显然是买入再卖出，都为0，第二笔买入是第一笔买入再卖出再买入，-prices[i]

        从小到大遍历顺序即可，最后返回dp[nums.length-1][4]，因为这个一定是最大的
     */

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][5];
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;

        for (int i = 1; i < len; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }

        return dp[len - 1][4];
    }

}
