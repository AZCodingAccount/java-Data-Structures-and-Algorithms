package com.zh.job.dp;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-21 09:44
 * @description: 不同路径—lc62
 **/
public class UniquePaths {
    /*
            求不同路径，就是相加的
        dp含义：dp[i][j]代表第i行第j列路径的个数(从0开始,如3行两列，右下角就是两行一列)
        递推公式：dp[i][j]=dp[i-1][j]+dp[i][j-1]
        初始化：第一行和第一列初始化成1
        遍历m和n，都从0开始遍历
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3, 7));
    }
}
