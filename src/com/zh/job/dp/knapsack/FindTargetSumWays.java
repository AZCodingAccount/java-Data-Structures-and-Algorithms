package com.zh.job.dp.knapsack;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-24 10:19
 * @description: 目标和—lc494
 **/
public class FindTargetSumWays {
    /*
            装满一个背包最多有多少种方法，目标和有 +，-两种情况，求target=多少，
            left+right=sum，left-right=target ，right消去，找一个相加为(sum+target)/2的个数DP四部曲
            dp[j]的含义代表总和为j的物品个数
            dp[j]=dp[j]+dp[j- nums[i]]  代表不放这个物品总和为j的个数相加和放这个物品总和为j的个数相加(考虑二维)
            dp[0]=1 数组长度为(sum+target)/2
            从0—>nums.length为第一层for循环,j——>0为内层for循环，最后返回dp[j]
     */

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if ((sum + target) % 2 != 0 || (sum + target) < 0) {
            return 0;
        }
        int targetSum = (sum + target) / 2;
        int[] dp = new int[targetSum + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = targetSum; j >= 0; j--) {
                if (j >= num) {
                    dp[j] = dp[j] + dp[j - num];
                }
            }
        }
        return dp[targetSum];
    }

    public static void main(String[] args) {
        System.out.println(new FindTargetSumWays().findTargetSumWays(new int[]{0, 0, 0, 0, 0}, 0));
    }
}
