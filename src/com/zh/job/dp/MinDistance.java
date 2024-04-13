package com.zh.job.dp;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-04-13 20:43
 * @description: 编辑距离——lc72 https://leetcode.cn/problems/edit-distance/description/
 **/
public class MinDistance {

    /*
            word1——>word2 插入、删除、更新三个操作，求最小操作数。这个dp思想是
        horse、roe   dp[i][j] 代表第一个字符串的前i个字符转换为第二个字符串的前j个字符的最小。
        min有三部分组成（分别对应插入、删除、更新），
            1：第一部分是 前i-1个字符转换成前j个字符 删除第i个字符                dp[i-1][j]+1
            2：第二部分是 前i个字符转换成前j-1个字符，往第一个字符串插入str2[j]    dp[i][j-1]+1
            3：第三部分是 前i-1个字符转换成前j-1个字符
                1： str[i]==str[j]    dp[i-1][j-1]
                2: str[i]!=str[j]   dp[i-1][j-1]+1
           dp多开两行，兼容i==0||j==0时 填表即可
               0    1   2   3
            0  0    1   2   3   ""——>"roe"
            1  1    1
            2  2
            3  3
            4  4
            5  5
            "horse" ——> ""
            理解的话就是4种可能的dp，实在不行全文背诵，挺好背的
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        char[] chs1 = word1.toCharArray();
        char[] chs2 = word2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        // 初始化第一行和第一列
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }

        // 填充dp数组
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // 先判断第三种情况
                if (chs1[i-1] == chs2[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // 第一和第二部分
                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j]);
                dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i][j]);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new MinDistance().minDistance("horse", "ros"));
    }
}
