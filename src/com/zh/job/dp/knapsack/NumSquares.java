package com.zh.job.dp.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-24 17:19
 * @description: 完全平方数—lc279
 **/
public class NumSquares {
    /*
        跟零钱兑换1一样，从一些物品里面找到背包容量为固定值的，需要注意的是完全平方数的处理，i*i<n
     */

    public int numSquares(int n) {
        List<Integer> goods = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i * i > n) {
                break;
            }
            goods.add(i * i);
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (Integer good : goods) {
            for (int i = good; i <= n; i++) {
                dp[i] = Math.min(dp[i], dp[i - good]+1);
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(new NumSquares().numSquares(12));
    }
}
