package com.zh.problem.stock;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-19 09:26
 * @description: 股票问题——最多k次leetcode188
 **/
public class Stock6 {
    /*
        Stock5是最多两次、这里参数通过k传过来了，直接定义二维数组即可。递推式不变
        dp[i][j][0]    代表前i个元素第j轮持有一个股票
        dp[i][j][1]    代表前i个元素第j轮交易结束
     */
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][k][2];
        // 初始化状态，初始化第一个元素的位置
        for (int i = 0; i < k; i++) {
            dp[0][i][0] = -prices[0];
            dp[0][i][1] = 0;   // 显式声明
        }
        // 开始dp
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                if (j == 0) {    // 记得初始化第一股
                    dp[i][j][0] = Math.max(-prices[i], dp[i - 1][j][0]);
                } else {    // 后面的轮数
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] - prices[i]);
                }
                dp[i][j][1] = Math.max(dp[i - 1][j][1], prices[i] + dp[i - 1][j][0]);
            }
        }
        // 最后的结果，卖出去的所有结果，dp[i][j][0] 的状态可以转换到dp[i-1][j-1][1]   显然<=  dp[i][j][1]
        // 因此，结果为在这k轮中取最大值，即dp[i][0] ——> dp[i][k-1] 状态也可以转换，即同一天买入或卖出
        return dp[prices.length - 1][k - 1][1];
    }

    public static void main(String[] args) {
        System.out.println(new Stock6().maxProfit(2, new int[]{2, 4, 1}));
    }
}
