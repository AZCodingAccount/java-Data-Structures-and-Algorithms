package com.zh.job.dp.subsequence;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-27 21:09
 * @description: 最长递增子数组—lc718
 **/
public class FindLength {
    /*
        dp[i][j]代表以nums1数组为结尾的前i-1个元素和以nums2数组为结尾的前i-1个元素的最长公共数组
        if nums[i]==nums[j] dp[i][j]=dp[i-1][j-1]+1     else dp[i][j]=0
        初始化都初始化为0
        两层for循环即可。为什么是i-1个元素而不是i个元素，因为这样可以免于特殊处理第一行和第一列，不然还得两for循环
     */
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        int max = 0;
        // 也差不多相当于暴力搜索了，只不过内层不是简单的双指针暴力遍历，而是使用dp保存了状态，因此是n^2级别的
        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = 0;    // 代表之前一切作废，去找新的
                max = Math.max(max, dp[i][j]);  // 每次都更新max
            }
        }
        return max;
    }
}
