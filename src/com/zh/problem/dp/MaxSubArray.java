package com.zh.problem.dp;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-05-10 21:52
 * @description: 最大子数组和——lc53
 **/
public class MaxSubArray {
    /*
     * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *   我觉得这道题可以用dp，dp[i,sum] 代表加入第i个元素且总和为sum后，当前所有元素的子数组最大和。
     * if(nums[i]>0){
     *      dp[i,sum]=dp[i-1,sum-nums[i-1]]+nums[i]
     * }else{
     *      加入该元素与不加入该元素的最大值
     *      dp[i]=max(dp[])
     * }
     * 但是要求必须连续，想一下滑动窗口。如果你加上这个负数小于0了，那么直接从头开始，不然right++，每次移动窗口时检查left小不小于0
     */

    public int maxSubArray(int[] nums) {
        int left = 0, right = 0;    // 初始化左右指针
        int sum = nums[0];  // 存储子数组的和
        while (left <= right && right < nums.length) {
            // 首先移动左指针，找到一个第一个不小于0的数
            while (nums[left] < 0) {
                sum -= nums[left];  // 更新子数组的值
                left++;
            }
            right = left + 1;   // 移动右指针
            // 考虑右边的元素可不可以加入子数组
            if (nums[right] + sum >= 0) {   // 加入子数组
                right++;
                sum += nums[right];
            } else {  // 不加入子数组
                left = right + 1;
                right = left;
                sum = 0;
            }
        }
    }
}
