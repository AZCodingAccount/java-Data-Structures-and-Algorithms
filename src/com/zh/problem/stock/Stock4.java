package com.zh.problem.stock;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-18 19:20
 * @description: 买卖股票含冷冻期——leetcode309
 **/
public class Stock4 {
    /*
            这次用一个二维dp，dp[i][0] 代表第i+1天持有一个股票   dp[i][1] 代表不持有股票且在冷冻期（今天刚卖）    dp[i][2]代表不持有股票
        prices=[1, 2, 3, 0, 2]
        初始化dp[0][0]=-1     dp[0][1]=0   dp[0][2]=0
        dp[i][0]=max(dp[i][2]-prices[i], dp[i-1][0])    // 今天刚买的(为什么没有冷冻期？因为他这里的表示是冷冻期后一天也不能买)    今天没买
        dp[i][1]=dp[i-1][0]+price[i]            // 只能说今天刚卖
        dp[1][2]=max(dp[i-1][1],dp[i-1][2])     // 昨天处于冷冻期或者昨天也不持有
     */

    /*
        满老师的解法：还是持有和不持有——对应当天买和当天卖,
            buy[i]=max(buy[i-1],sell[i-2]-price[i])     // 今天买的情况一定是前天卖了，过了一天冷静期，至于大前天卖就不在dp的考虑范围。
            sell[i]=max(sell[i-1],buy[i-1]+price[i])

     */

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][2] - prices[i], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }

        return Math.max(Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]), dp[prices.length - 1][2]);
    }
    /*  1   2   3
    *   -1  0   0
    *   -1  1   0
    *   -1  2   0
    * */

    public static void main(String[] args) {
        System.out.println(new Stock4().maxProfit(new int[]{1, 2, 3}));
    }
}
