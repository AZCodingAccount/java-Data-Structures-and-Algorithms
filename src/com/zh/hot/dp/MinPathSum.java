package com.zh.hot.dp;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-11 17:04
 * @description: 最小路径和—lc64
 **/
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) dp[i][j] = grid[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }
}
