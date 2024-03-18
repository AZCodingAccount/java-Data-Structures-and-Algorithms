package com.zh.algorithm.dp;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-13 14:52
 * @description: 打家劫舍——LCR89
 **/
public class Rob {

    /*
        一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响小偷偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
        给定一个代表每个房屋存放金额的非负整数数组 nums ，请计算 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
        [1,2,3,1]   dp[i]   代表考虑前i个房间的时候，偷窃的最高金额
        一共有两个选择，偷或者不偷
        if(i==1)    dp[i]=nums[i]
        if(i==2)    dp[i]=max(nums[i],nums[i-1])
        i>=3的时候     偷这个房间，就不能偷前一个房间。
        dp[i]=max(dp[i-2]+nums[i],dp[i-1])
     */
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        if (n == 1) {
            return dp[0];
        }
        dp[1] = Math.max(nums[0], nums[1]);
        if (n == 2) {
            return dp[1];
        }

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Rob().rob(new int[]{1, 2, 3, 1}));
    }
}
