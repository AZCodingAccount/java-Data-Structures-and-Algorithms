package com.zh.problem.stock;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-18 17:01
 * @description: 含手续费的股票问题——leetcode714
 **/
public class Stock3 {
    /*
            跟贪心那道题就不一样了，这次有手续费，就不能不停地买入买出。因此使用DP，两个状态转移数组
         prices=[1, 3, 2, 8, 4, 9]  规定出售时候付手续费
         可以对应题解中的手里持有股票和手里没有股票的两种状态
         buy[i] 代表第i天股票买的赚的最多钱    sell[i] 代表第i天股票买的赚的最多钱
        对price[0]: buy[0] -1    sell[0] 0
          price[1]: buy[1]  max(sell[0]-price[1], buy[0])       0 说明不买，上次卖赚的钱-这次的价格 不如 上次买          买了  不买
                    sell[1] max(price[1]+buy[0]-fee, sell[0])      卖出去，这次卖的钱-上次买的钱-手续费 比上次卖出去好    卖了，不卖
     */
    public int maxProfit(int[] prices, int fee) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(sell[i - 1] - prices[i], buy[i - 1]);
            sell[i] = Math.max(prices[i] + buy[i - 1] - fee, sell[i - 1]);
        }
        return sell[prices.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Stock3().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
