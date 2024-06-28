package com.zh.job.dp.subsequence;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-28 19:09
 * @description: 编辑距离—lc72
 **/
public class MinDistance2 {
    /*
        最经典的题目，实际上只用到了删除和修改两个，增加和删除相同，适合全文背诵。
    DP含义
        dp[i][j]代表前i-1个元素和前j-1个元素相等所需要移动的最小步数
    递推式
        if(chs1[i]==chs2[j])    dp[i][j]=dp[i-1][j-1]
        else    dp[i][j]=min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+1)
        1：删除第一个字符串的字符。2：删除后一个字符串的字符。3：修改字符使得相等。4：同时删除两个字符串的字符被包括进前两种情况了
    初始化
        很有讲究。i==0时，dp[0][j]=j。j==0时，dp[i][0]=i;并且尽量在循环之前初始化，一个习惯，这里在哪初始化都可以。
    遍历顺序
        两层for循环遍历，最后返回dp[s1.length][s2.length]
     */
    public int minDistance(String word1, String word2) {
        char[] chs1 = word1.toCharArray();
        char[] chs2 = word2.toCharArray();
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 初始化
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (chs1[i - 1] == chs2[j - 1]) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
            }
        }
        return dp[len1][len2];
    }
}
