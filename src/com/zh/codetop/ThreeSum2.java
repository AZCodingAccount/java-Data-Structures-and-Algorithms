package com.zh.codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-12-03 00:19
 * @description:
 **/
public class ThreeSum2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int fixed = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 寻找一个有序数组的元素之和等于-fixed
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if ((nums[left] + nums[right] + fixed) > 0) {
                    // 尝试缩小范围
                    right--;
                } else if ((nums[left] + nums[right] + fixed) < 0) {
                    left++;
                } else {  // 收集结果
                    res.add(List.of(fixed, nums[left], nums[right]));
                    // b、c去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
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
