package com.zh.job;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-19 16:45
 * @description: 找出多数元素——leetcode169
 **/
public class MajorityElement {
    /*
        1: 排完序以后，在中间的那个数就是多数元素
        2：哈希表，统计数字出现的个数
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
