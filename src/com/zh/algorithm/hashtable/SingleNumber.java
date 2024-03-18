package com.zh.algorithm.hashtable;

import java.util.HashSet;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-05 21:02
 * @description: 只出现一次的数字—力扣136题
 **/
public class SingleNumber {

    /*
            给你一个非空整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
            题目要求必须在线性时间，且常量额外空间。思路如下：
                使用HashSet|HashMap集合，遍历数组，发现数组中有元素重复的，就把该元素移除，说明通过校验。
            遍历到最后，剩下的唯一元素就是要找的元素，注意，不能使用HashMap存储键值不移除，这样就不是常量额外空间了
     */
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                // 有重复的元素
                set.remove(num);
            }
        }
        for (Integer integer : set) {
            return integer;
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(new SingleNumber().singleNumber(new int[]{1, 2, 1}));    // 2
    }
}
