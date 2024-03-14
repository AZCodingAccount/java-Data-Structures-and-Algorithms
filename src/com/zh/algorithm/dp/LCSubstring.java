package com.zh.algorithm.dp;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-11 21:44
 * @description: 最长公共子串
 **/
public class LCSubstring {
    /*
            dp[i][j]为前i和前j个字符的最长子串长度，行为s1、列为s2   给出最长公共子串的递推式：
            if(s1[i]==s1[j]){
                dp[i][j]=dp[i-1][j-1]+1
            }else{
                dp[i][j]=0
            }
     */

    public int lcs(String s1, String s2) {
        // 转换成字符数组
        char[] s1CharArray = s1.toCharArray();
        char[] s2CharArray = s2.toCharArray();

        int[][] dp = new int[s1CharArray.length + 1][s2CharArray.length + 1]; // 存储长度，多出来一行一列处理第一行和第一列


        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (s1CharArray[i-1] == s2CharArray[j-1]) { // 可以增加当前子串的长度，注意是i-1，有一行一列无实际意义
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {    // 一次回到解放前
                    dp[i][j] = 0;
                }
            }
        }

        return Arrays.stream(dp).flatMapToInt(Arrays::stream).max().getAsInt(); // 在dp矩阵中找到最大的
    }

    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "dfe";
        System.out.println(new LCSubstring().lcs(s1, s2));
    }
}
