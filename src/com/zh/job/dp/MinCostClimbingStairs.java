package com.zh.job.dp;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-21 09:23
 * @description: 使用最小花费爬楼梯—lc746
 **/
public class MinCostClimbingStairs {
    /*
        最小花费爬楼梯
        dp[i]代表爬到第i个台阶的最小花费
        dp[i]=min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])
        初始化条件dp[0]=0,dp[1]=0
        从2开始遍历，遍历到n，返回dp[n]
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}
