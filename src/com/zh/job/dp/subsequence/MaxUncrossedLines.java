package com.zh.job.dp.subsequence;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-27 21:45
 * @description: 不相交的线—lc1035
 **/
public class MaxUncrossedLines {
    /*
        不相交的线实际上就是求最长公共子序列，易知不相交线最多一定是都是垂直的直线的情况
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];

        int max = 0;
        // 也差不多相当于暴力搜索了，只不过内层不是简单的双指针暴力遍历，而是使用dp保存了状态，因此是n^2级别的
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else {
                    // 这里是子序列，如果不相等，就从三个状态中取一个最大的，对应公共子序列的最长值
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[len1][len2];
    }
}
