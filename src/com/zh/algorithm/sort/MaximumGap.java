package com.zh.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-07 13:36
 * @description: 最大间距——leetcode164题
 **/
public class MaximumGap {
    /*
            给定一个无序的数组 nums，返回数组在排序之后，相邻元素之间最大的差值 。如果数组元素个数小于 2，则返回 0 。
            您必须编写一个在「线性时间」内运行并使用「线性额外空间」的算法。
            两个思路。
                1：使用基数排序排序完毕以后然后双指针遍历即可求出
                2：使用桶排序，定义一个合适的range，只需求相邻桶的最小值和最大值的之差
            使用基数排序
                1：求出数组的每一位数，循环轮数，直到所有元素的位数均为0代表轮数结束
                2：线性时间遍历一次
     */

    public int maximumGap(int[] nums) {
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {  // 初始化10个桶
            buckets.add(new ArrayList<>());
        }

        // 每一轮
        int pow = 0;
        int maxValue = Arrays.stream(nums).max().getAsInt();
        int maxRound = 0;
        // 求出最大值的位数
        while (maxValue / 10 != 0) {
            maxValue /= 10;
            maxRound++;
        }

        while ((maxRound--)>=0) {    // 当前遍历几轮
            for (int num : nums) {
                // 4123         13 29 6 1
                // 4123%10=3    4123/10%10=2    4123/(10*10)%10=1     4123/(10*10*10)%10=4
                int bit = (int) ((num / Math.pow(10, pow)) % 10);   // 求出每一位
                // 优化代码
                buckets.get(bit).add(num);
            }
            pow++;  // 更新取出的位数
            // 取出本轮排序号的元素并清空桶
            int index = 0;
            for (List<Integer> bucket : buckets) {
                for (Integer ele : bucket) {
                    nums[index++] = ele;
                }
                bucket.clear();  // 清空每个桶中的元素
            }
        }
        int maxGap = 0;
        // 遍历排序好的元素求出maxLength
        for (int i = 1; i < nums.length; i++) {
            maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
        }
        return maxGap;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 40};
        System.out.println(new MaximumGap().maximumGap(nums));
    }
}
