package com.zh.job.hashtable;

import java.util.*;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-14 20:48
 * @description: 三数之和—lc15
 **/
public class ThreeSum {

    /**
     * 注意题目要求不可以包含重复的三元组且索引不能相同，具体思路就是固定一个数，然后移动另外两个数
     **/
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {  // 没救了，后面的也没必要遍历所以return而非break
                return res;
            }
            // 去重a
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 赋值left和right
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum + nums[i] > 0) {  // 说明大了，right左移
                    right--;
                } else if (sum + nums[i] < 0) { // 说明小了，left右移
                    left++;
                } else {
                    // 找到一个三元组
                    List<Integer> triple = Arrays.asList(nums[i], nums[left], nums[right]);
                    res.add(triple);
                    // 去重bc
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    // 移动指针，继续寻找
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
