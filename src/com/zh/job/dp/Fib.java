package com.zh.job.dp;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-20 21:36
 * @description: 斐波那契数列—lc509
 **/
public class Fib {
    /*
        递归5部曲！
        1：dp[i]含义：dp[i]代表第i个数的斐波那契值
        2：递推公式：dp[i]=dp[i-1]+dp[i-2]
        3：初始化：dp[0]=0,dp[1]=1
        4：遍历顺序：从i-2——>n
     */

    public int fib(int n) {
        // 初始化
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
