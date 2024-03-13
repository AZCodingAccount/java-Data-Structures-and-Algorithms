package com.zh.algorithm.dp;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-11 21:59
 * @description: 最长公共子序列
 **/
public class LCSubSequence {
    /*
        跟最长公共子串的思想一样，但是有一些区别，比如 abcdef  和 aef 的最长公共子串长度为1，但是最长公共子序列为aef，3
            dp[i][j]为前i和前j个字符的最长子序列长度，行为s1、列为s2   给出最长公共子序列的递推式：
                    if(s1[i]==s2[j]){
                        dp[i][j]=dp[i-1][j-1]+1
                    }else{
                        dp[i][j]=max(dp[i-1][j],dp[i][j-1]
                    }
     */

    public int longestCommonSubsequence(String text1, String text2) {
        // 求出子串长度
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1]; // 多出来一行一列初始化成0

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {   // 兼容第一行第一列无实际意义
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];    // 最后一个一定是最大的
    }


    public static void main(String[] args) {
        System.out.println(new LCSubSequence().longestCommonSubsequence("abcdef", "aef"));
    }

}
