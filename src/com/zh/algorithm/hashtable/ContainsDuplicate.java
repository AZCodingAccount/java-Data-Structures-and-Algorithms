package com.zh.algorithm.hashtable;

import java.util.HashSet;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-05 20:39
 * @description: 判断数组是否有重复元素—力扣217题
 **/
public class ContainsDuplicate {

    /*
            给你一个整数数组 nums 。如果任一值在数组中出现至少两次，返回 true；如果数组中每个元素互不相同，返回 false 。
                解法1：遍历，这样会达到n-1+n-2+...到O(n^2)量级
                解法2：排序后只用一次扫描即可，时间复杂度O(nlogn)
                解法3：先遍历把值全塞给哈希表，再遍历判断是否有重复的
                      一次遍历，边遍历边往哈希表插入元素，知道找到了重复的或者遍历结束
                 解法1和解法2超时过不去，解法3虽然都是O(n)，第一种显然没有第二种优秀
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                // 有重复的元素
                return true;
            }
        }
        // 说明遍历结束还是没有重复的元素
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ContainsDuplicate().containsDuplicate(new int[]{1, 2, 3, 1}));   // true
        System.out.println(new ContainsDuplicate().containsDuplicate(new int[]{1, 2, 3}));   // false
    }
}
