package com.zh.job.hashtable;

import java.util.HashMap;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-14 20:03
 * @description: 四数相加—lc454
 **/
public class FourSumCount {

    /**
     * 可以使用一个hashmap存前两个数组的所有组合之和，key为和的值，value为和的组合数。后两个同理，这样时间复杂度就减少到了O（n^2）
     * 计算满足元组的数量时，将两个value<b>相乘</b>即可
     **/
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        // 初始化两个map
        for (int j : nums1) {
            for (int k : nums2) {
                int sum = j + k;
                map1.compute(sum, (key, val) -> val == null ? 1 : val + 1);
            }
        }
        int totalCount = 0;

        for (int j : nums3) {
            for (int k : nums4) {
                int sum = j + k;
                Integer value = map1.get(-sum);
                if (value != null) {
                    totalCount += value;
                }
                // map2.compute(sum, (key, val) -> val == null ? 1 : val + 1);
            }
        }

        // 遍历map计算总个数
        // for (Integer sum1 : map1.keySet()) {
        //     Integer num2 = map2.get(-sum1);
        //     if (num2 != null) { // 说明后两个数组能匹配
        //         Integer num1 = map1.get(sum1);
        //         totalCount += num1 * num2;
        //     }
        // }
        return totalCount;
    }
}
