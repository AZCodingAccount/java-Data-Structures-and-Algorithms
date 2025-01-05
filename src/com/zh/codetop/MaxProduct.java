package com.zh.codetop;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-12-12 23:58
 * @description:
 **/
public class MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int len = nums.length;
        double max = nums[0], min = nums[0];   // max|min是算上当前元素的最大值|最小值
        long res = 0;
        for (int i = 1; i < len; i++) {
            long tempMax = (long) Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
            long tempMin = (long) Math.min(nums[i], Math.min(nums[i] * max, nums[i] * min));
            max = tempMax;
            min = tempMin;
            res = (long) Math.max(res, max);
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProduct().maxProduct(new int[]{-4, -3, -2}));
    }
}
