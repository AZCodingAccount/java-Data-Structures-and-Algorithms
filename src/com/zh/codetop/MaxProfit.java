package com.zh.codetop;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-14 20:29
 * @description:
 **/
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE, minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(price, minPrice);
        }
        return Math.max(maxProfit, 0);
    }
}
