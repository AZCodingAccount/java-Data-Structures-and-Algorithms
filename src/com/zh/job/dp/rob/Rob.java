package com.zh.job.dp.rob;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-24 19:44
 * @description: 打家劫舍—lc198
 **/
public class Rob {
    /*
        偷，还是不偷？这是个问题
        dp[i]代表偷到了第i个房子的最高金额
        dp[i]=max(dp[i-2]+nums[i],dp[i-1]) 偷这家还是不偷这家
        dp[0]=nums[0],其他都初始化成0
        遍历数组
     */
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length == 1) {
            return dp[0];
        }
        dp[1] = Math.max(nums[0], nums[1]);
        if (nums.length == 2) {
            return dp[1];
        }
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Rob().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new Rob().rob(new int[]{2, 7, 9, 3, 1}));
    }
}
