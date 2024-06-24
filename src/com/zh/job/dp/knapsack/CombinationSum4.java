package com.zh.job.dp.knapsack;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-24 15:24
 * @description: 组合总和4—lc377
 **/
public class CombinationSum4 {
    /*
        求和为target的组合个数，这不跟零钱兑换一样吗
        dp[j]=dp[j]+dp[j-nums[i]]
     */

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 0; j <= target; j++) {
            System.out.println(j);
            for (int num : nums) {
                if (j >= num) {
                    dp[j] = dp[j] + dp[j - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum4().combinationSum4(new int[]{1, 2, 5}, 5));
    }
}
