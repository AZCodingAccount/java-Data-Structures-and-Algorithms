package com.zh.problem.stock;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-18 11:39
 * @description: 股票问题1——leetcode121
 **/
public class Stock1 {
    /*
        定义一个minPrice记录当前最低价格
        1：碰到小于这个变量的，更新变量
        2：大于变量的，更新maxProfit
        思想是只有股票价格高的情况下才出售
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(price - minPrice, maxProfit);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new Stock1().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }


}
