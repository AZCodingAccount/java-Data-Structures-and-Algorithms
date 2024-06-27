package com.zh.job.dp.subsequence;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-27 20:45
 * @description: 最长连续递增子序列—lc674
 **/
public class FindLengthOfLCIS {
    /*
        这次要求连续递增子序列，因此就很简单了，每次判断自己比前一个是不是大，是的话+1，不是的话从0开始。双指针更简单
     */
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) dp[i - 1]++;
            else dp[i] = 1;
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new FindLengthOfLCIS().findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
    }
}
