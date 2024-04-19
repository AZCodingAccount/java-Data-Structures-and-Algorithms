package com.zh.job.hashtable;

import java.util.HashSet;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-04-19 20:44
 * @description: 最长连续序列——lc128
 **/
public class LongestConsecutive {

    /*
            要求时间复杂度为O（n），使用hashset，对每一个元素都需要判断他的连续子序列的长度，意味着最坏时间复杂度是O(n^2)。
        这个时候只需要判断该元素的前一个元素存不存在哈希表中
                1：如果存在，说明当前元素被统计过了或被以后得统计，就跳过
                2：如果不存在，说明当前是第一个元素，递归的更新最长长度
        比如[100, 4, 200, 1 ,3 ,2]
        100, 99不在哈希表中，101也不在, len=1
        4，  3在哈希表中，跳过
        200  199不在哈希表中，201也不在，len=1
        1   0不在哈希表中，2在，len=2,3在，len=3，4在len=4
        ......
        最后len=4
     */

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int res = Integer.MIN_VALUE;    // 最长长度
        HashSet<Integer> set = new HashSet<>();
        // 初始化哈希表
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int len = 1;    // 本数字的连续序列长度
                int x = num + 1;
                while (set.contains(x)) {
                    len++;
                    x++;
                }
                res = Math.max(len, res);  // 更新结果
            }
        }
        return res;
    }
}
