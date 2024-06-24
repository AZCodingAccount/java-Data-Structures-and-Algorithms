package com.zh.job.dp.knapsack;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-24 14:17
 * @description: 一和零—lc474
 **/
public class FindMaxForm {
    /*
            0-1背包的又一个变种，这次是装了容量为m、n的最大子集数量。
        dp[i][j] 代表装了i个0、j个1所包含的最大子集数量
        dp[i][j]=max(dp[i-x][j-y]+1,dp[i][j])     表示装了当前这个物品的子集数量和不装取一个最大值
        初始化 dp[0][0]=0,其余的也初始化为0，dp[m+1][n+1]
        遍历顺序，三层for循环即可，内层循环都从后往前遍历
     */

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1]; // dp数组

        for (String str : strs) {
            int x = 0;
            int y = 0;
            char[] chs = str.toCharArray();
            // 统计0和1的个数，便于后面比较
            for (char ch : chs) {
                if (ch == '0') x++;
                if (ch == '1') y++;
            }
            for (int j = m; j >= x; j--) {
                for (int k = n; k >= y; k--) {
                    dp[j][k] = Math.max(dp[j - x][k - y] + 1, dp[j][k]);
                }
            }
        }
        return dp[m][n];
    }
}
