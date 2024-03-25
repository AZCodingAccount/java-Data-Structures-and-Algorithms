package com.zh.problem.stock;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-19 09:04
 * @description: 股票问题5——最多完成两笔交易leetcode123
 **/
public class Stock5 {
    /*
            持有第一股、完成了一笔交易、持有第二股、完成了两笔交易
            prices = [3,3,5,0,0,3,1,4]
                f0[i]=max(-price[i],f0[i-1])                 这一轮买或者之前买
                f1[i]=max(f1[i-1],price[i]+f0[i-1])          这一轮卖或者之前卖
                f2[i]=max(f2[i-1],f1[i-1]-price[i])
                f3[i]=max(f3[i-1],price[i]+f2[i-1])
            初始状态：
                f0[0] = -prices[0]; f1[0]=0
                f2[0] = -prices[0]; f3[0]=0
           也可以降维，4个变量就可以
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] f0 = new int[n];
        int[] f1 = new int[n];
        int[] f2 = new int[n];
        int[] f3 = new int[n];
        f0[0] = -prices[0];
        f2[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            f0[i] = Math.max(-prices[i], f0[i - 1]);
            f1[i] = Math.max(f1[i - 1], prices[i] + f0[i - 1]);
            f2[i] = Math.max(f2[i - 1], f1[i - 1] - prices[i]);
            f3[i] = Math.max(f3[i - 1], prices[i] + f2[i - 1]);
        }

        return Math.max(f1[n - 1], f3[n - 1]);
    }

    public static void main(String[] args) {
        System.out.println(new Stock5().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
}
