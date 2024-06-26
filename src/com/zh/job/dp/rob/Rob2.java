package com.zh.job.dp.rob;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-24 20:18
 * @description: 打家劫舍2—lc213
 **/
public class Rob2 {
    /*
        打家劫舍二连成了环，分类讨论，一共有三种情况。
        1：不偷第一个和不偷最后一个
        2：偷第一个但不偷最后一个
        3：不偷第一个但偷最后一个
        第一种情况的最大值被下面两种包含了，因此取下面两种的最大值。
     */

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob2(nums, 0, nums.length - 1), rob2(nums, 1, nums.length));
    }

    // 包左不包右
    public int rob2(int[] nums, int start, int end) {
        int length = end - start;
        int first = nums[start];
        if (length == 1) {
            return first;
        }
        int second = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(second, first + nums[i + start]);
            first = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(new Rob2().rob(new int[]{1, 2, 1, 1}));
        // System.out.println(new Rob2().rob(new int[]{1,2,3,1}));
    }
}
