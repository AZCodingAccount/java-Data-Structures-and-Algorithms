package com.zh.job.dp;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-21 10:05
 * @description: 不同路径II—lc63
 **/
public class UniquePathsWithObstacles {
    /*
          求不同路径，考虑到有障碍物的情况，主要注意第一行和第一列的情况，如果把路封死了，后面的都走不了。
      dp含义：dp[i][j]代表第i行第j列路径的个数(从0开始,如3行两列，右下角就是两行一列)
      递推公式：dp[i][j]=dp[i-1][j]+dp[i][j-1]
      初始化：第一行和第一列初始化成1
      遍历m和n，都从0开始遍历
   */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;    // 行
        int m = obstacleGrid[0].length; // 列
        if (obstacleGrid[0][0] == 1 || obstacleGrid[n - 1][m - 1] == 1) {   // 出口有障碍物或者入口有
            return 0;
        }
        int[][] dp = new int[n][m];
        // 这次先初始化，在循环里面初始化还需要定义两变量跳过障碍后面走不到的情况
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] += dp[i - 1][j];
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePathsWithObstacles().uniquePathsWithObstacles(new int[][]{{1, 0}}));
    }
}
