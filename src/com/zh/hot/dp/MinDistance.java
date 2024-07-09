package com.zh.hot.dp;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-09 09:46
 * @description: 编辑距离
 **/
public class MinDistance {
    /*
        dp[i][j]表示前i-1个元素和前j-1个元素的最少操作数
        if(word1[i-1]==word2[j-1]) // 删除或替换 min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]+1)
        初始化阶段：dp[0][j]=j,dp[i][0]=i
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) != word2.charAt(j - 1))
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
                else dp[i][j] = dp[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }
}
