package com.zh.job.dp.subsequence;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-27 20:26
 * @description: 最长递增子序列长度—lc300
 **/
public class LengthOfLIS {
    /*
        求最长递增子序列，使用DP是N^2，递归四部曲
    dp含义
        dp[i]代表前i个元素的最长递增子序列长度
    递推公式
        dp[i]=max(dp[j]+1,dp[i])    j为[0,i-1]
    初始化
        所有元素都初始化成1，因为自己一定是一个长度为1的序列
    遍历顺序
        外层nums.length，内层[0,i-1]
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLIS().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
