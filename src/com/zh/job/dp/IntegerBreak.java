package com.zh.job.dp;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-21 11:05
 * @description: 整数拆分—lc343
 **/
public class IntegerBreak {
    /*
           代表的含义：dp[i]代表给定一个i，拆分后乘积最大的值
           递推式：dp[i]=max(j*dp[i-j],j*(i-j))
           初始化：dp[0]=0,dp[1]=0,dp[2]=1;
           循环：从3-n，dp[n]为给定值
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;  // 1*1
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {  // 以3为例，j=1，j=2。dp递推式的值为1*2,2*1 与 1*1*1、0比较.
                dp[i] = Math.max(j * (i - j), Math.max(j * dp[i - j], dp[i]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(10));
    }
}
