package com.zh.job.dp;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-20 21:43
 * @description: 爬楼梯—lc70
 **/
public class ClimbStairs {
    /*
        跟着dp4部曲来就行，（woc这不是斐波那契数列吗）
        1：dp[i]代表有i个台阶，多少种爬法
        2：dp[i]=dp[i-1]+dp[i-2]
        3：dp[1]=1,dp[2]=2,长度n+1,第0个不要
        4：从3循环
     */

    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
