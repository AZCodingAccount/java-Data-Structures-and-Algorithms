package com.zh.algorithm.hashtable;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-05 13:20
 * @description: 两数之和E01
 **/
public class TwoSum {
    /*
        给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target的那两个整数，并返回它们的数组下标。
            1：暴力求解是可行的，双重for即可
            2：使用hash表O(1)的新增和查找速度，可以在O(n)内完成。思路为遍历一次将元素记录到哈希表中，key为nums[i],value为索引
            最后找差值在不在哈希表中，在的话取出索引即可，不在的话加入哈希表继续向下遍历
     */
    public int[] twoSum(int[] nums, int target) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        for (int i = 0; i < nums.length; i++) {
            // 要查找的元素
            int another = target - nums[i];
            Integer indexValue = hashtable.get(another);
            if (indexValue != null) {
                // 找到了，返回这两个索引
                return new int[]{indexValue, i};
            } else {
                // 加入哈希表中
                hashtable.put(nums[i], i);
            }
        }
        // 遍历完毕没找到返回null
        return null;
    }

    public static void main(String[] args) {
        int[] results = new TwoSum().twoSum(new int[]{1, 3, 5, 7}, 4);
        System.out.println(Arrays.toString(results));
    }

}
