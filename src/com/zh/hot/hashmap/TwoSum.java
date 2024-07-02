package com.zh.hot.hashmap;

import java.util.HashMap;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-02 10:19
 * @description: 两数之和—lc1
 **/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();   // 键为数组原始，值为数组索引
        for (int i = 0; i < nums.length; i++) {
            Integer origin = map.get(target - nums[i]);
            if (origin != null) {
                return new int[]{origin, i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
