package com.zh.job.hashtable;

import java.util.HashMap;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-30 21:37
 * @description: 存在重复元素2——leetcode219
 **/
public class ContainsNearbyDuplicate {
    /*
            使用哈希表存储元素，
        1：如果碰到key重复的，就将索引取出来和当前索引比较，满足条件就返回true,不满足条件返回false
        2：没有碰到key重复的，加入哈希表
        这样一次遍历即可判断
     */

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) { // key相等
                Integer j = hashMap.get(nums[i]);
                if (Math.abs(i - j) <= k) {
                    return true;
                } else {  // 更新num[i]保存的索引
                    hashMap.put(nums[i], i);
                }
            } else {  // key不存在
                hashMap.put(nums[i], i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ContainsNearbyDuplicate().containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    }
}
