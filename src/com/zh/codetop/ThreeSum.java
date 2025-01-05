package com.zh.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-12 00:48
 * @description: 三数之和—lc15
 **/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) return res;
            int fix = nums[i];
            // 去重a
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            // 求结果
            while (left < right) {
                if ((fix + nums[left] + nums[right]) > 0) {
                    right--;
                } else if ((fix + nums[left] + nums[right]) < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(fix, nums[left], nums[right]));
                    // 去重bc
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
