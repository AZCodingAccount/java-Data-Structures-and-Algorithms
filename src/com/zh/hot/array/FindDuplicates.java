package com.zh.hot.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-21 19:29
 * @description: 数组中重复的数据—lc442
 **/
public class FindDuplicates {
    /*
        思路就是把每个数交换到他本该在的位置，类似于线性探测法解决哈希冲突
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 不停交换
            while (i != nums[i] - 1) {
                if (nums[i] == nums[nums[i] - 1]) break;    // 防止死循环，不让两个相等的数一直叫唤
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int idx = nums[i] - 1;  // 当前要处理的索引位置，[1,n]对应到索引是[0,n-1]
            // 先考虑这个位置是不是有人了，如果有人了，就是结果
            if (i != idx && nums[idx] == nums[i]) {
                res.add(nums[i]);
            }
        }
        return res;
    }

    private static void swap(int[] nums, int p, int idx) {
        // 没人，交换到正确的位置上
        int temp = nums[p];
        nums[p] = nums[idx];
        nums[idx] = temp;
    }

    public static void main(String[] args) {
        // System.out.println(new FindDuplicates().findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        // System.out.println(new FindDuplicates().findDuplicates(new int[]{1}));
        // System.out.println(new FindDuplicates().findDuplicates(new int[]{5, 4, 6, 7, 9, 3, 10, 9, 5, 6}));
        System.out.println(new FindDuplicates().findDuplicates(new int[]{3, 11, 8, 16, 4, 15, 4, 17, 14, 14, 6, 6, 2, 8, 3, 12, 15, 20, 20, 5}));
    }
}
