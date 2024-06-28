package com.zh.job.dp.subsequence;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-28 09:42
 * @description: 最大子数组和—lc53
 **/
public class MaxSubArray {
    /*
        之前使用贪心的方法解决了，现在使用dp，最大子数组和，加上这个数和不加这个数，如果加起来不小于0，那我就加进去
    DP含义
        dp[i]表示以nums[i]结尾的前面最大子数组和（必须包含nums[i]，注意最大值在各个dp值中）
    递推式
        if(dp[i-1]>=0) dp[i]=dp[i-1]+nums[i]    前面的累计子数组和大于0，还有存续的必要
        else dp[i]=nums[i]      重新开始
    初始化
        dp[0]=nums[0]
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) dp[i] = dp[i - 1] + nums[i];
            else dp[i] = nums[i];
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
