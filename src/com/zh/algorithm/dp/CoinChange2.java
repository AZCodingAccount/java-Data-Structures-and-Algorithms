package com.zh.algorithm.dp;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-11 20:00
 * @description: 零钱兑换问题2
 **/
public class CoinChange2 {
    /*
        dp数组行 为硬币所有面值，列为总金额。dp[i][j]为前i种硬币装j元时的方式
            if(装不下){
                dp[i][j]=dp[i-1][j]
            }else{
                装得下
                dp[i][j]=dp[i-1][j]+dp[i][j-item.value]
                对递推式的解释，首先需要加上没有添加上这枚硬币面值的个数，还有一个是刨去这枚硬币的个数
            }
     */
    public int change(int[] coins, int amount) {
        // 2  3
        int[][] dp = new int[coins.length + 1][amount + 1]; // 初始化状态数组多了一行一列用来兼容
        // 初始化第一列
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        // 开始dp
        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {  // 总金额
                if (j < coins[i - 1]) {     // 硬币比总金额还大
                    dp[i][j] = dp[i - 1][j];
                } else {  // 硬币小于总金额
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{2};
        int amount = 3;
        System.out.println(new CoinChange2().change(coins, amount));
    }
}
