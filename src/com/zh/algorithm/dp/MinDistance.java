package com.zh.algorithm.dp;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-12 15:53
 * @description: 两个字符串的删除操作——583题
 **/
public class MinDistance {

    /*
        给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
        每步可以删除任意一个字符串中的一个字符。

        本质上是最长公共子序列（不能是子串或者说子字符），求出最长子序列，word1.length-LCS+word2.length-LCS
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        char[] array1 = word1.toCharArray();
        char[] array2 = word2.toCharArray();

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (array1[i - 1] == array2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new MinDistance().minDistance("sea", "eat"));
    }
}
