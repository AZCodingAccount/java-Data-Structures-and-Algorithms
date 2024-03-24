package com.zh.problem.stock;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-18 16:44
 * @description: 股票问题2——leetcode122
 **/
public class Stock2 {
    /*
        相较于股票问题1增加了可以随便买的条件，这就可以采取贪心的策略，
        1：只要能赚钱我就卖出，改变sum。再当天买回来
        2：价格低我就更新，卖出买入
     */

    public int maxProfit(int[] prices) {
        int sum = 0;  // 能赚的所有钱
        int buyPrice = Integer.MAX_VALUE; // 买入的价格
        for (int price : prices) {
            if (price > buyPrice) {
                sum += price - buyPrice;
            }
            buyPrice = price;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Stock2().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
