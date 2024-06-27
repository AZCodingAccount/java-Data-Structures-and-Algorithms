package com.zh.job.dp.subsequence;

import org.junit.platform.commons.util.StringUtils;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-27 21:23
 * @description: 最长公共子序列—lc1143
 **/
public class LongestCommonSubsequence {
    /*
        跟求子数组一样，不过需要注意的是子数组是连续的，子序列是不连续的。
     */

    public int longestCommonSubsequence(String text1, String text2) {
        if ("".equals(text1) || "".equals(text2)) return 0;
        char[] chs1 = text1.toCharArray();
        char[] chs2 = text2.toCharArray();
        int m = chs1.length;
        int n = chs2.length;
        int[][] dp = new int[m + 1][n + 1];

        int max = 0;
        // 也差不多相当于暴力搜索了，只不过内层不是简单的双指针暴力遍历，而是使用dp保存了状态，因此是n^2级别的
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (chs1[i - 1] == chs2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else {
                    // 这里是子序列，如果不相等，就从三个状态中取一个最大的，对应公共子序列的最长值
                    // 实际上直接求i和j-1、j和i-1即可。i-1,j-1被前两者包含进来了。前两者一定大于i-1,j-1
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abcde", "ace"));
    }
}
