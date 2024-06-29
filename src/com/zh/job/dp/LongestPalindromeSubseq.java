package com.zh.job.dp;

import com.zh.job.dp.subsequence.LongestCommonSubsequence;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-29 21:16
 * @description: 最长回文子序列—lc516
 **/
public class LongestPalindromeSubseq {
    /*
         这种求个数的适合使用dp来解决，但是这个比较绕，记住就可以了
     dp含义
         dp[i][j]代表从[i,j]的子序列的最大长度
     递推式
         if(s[i]==s[j]) dp[i][j]=dp[i+1][j-1]+2
         当i==j的时候 dp[i][j]=1 i+1=j的时候aa dp[i][j]=2; 其他情况 aba这里依赖前一个状态即可
         else dp[i][j]=max(dp[i+1][j],dp[i][j-1])
     初始化
         全部初始化成0
     遍历顺序
         外层i，内层j，i从s.length-1——>0，j从i到s.length-1
     最后返回res
  */
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j <= length - 1; j++) {
                if (s.charAt(i) == s.charAt(j)) {   // 两个字符相等时的处理
                    if (i == j) dp[i][j] = 1;
                    else if (i + 1 == j) dp[i][j] = 2;
                    else dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {  // 字符不想等时的处理
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][length - 1];     // 从0到length-1代表了最大串，求这个的子序列
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromeSubseq().longestPalindromeSubseq("bbbab"));
    }
}
