package com.zh.job.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-14 21:49
 * @description: 四数之和—lc18
 **/
public class FourSum {
    /**
     * 沿用三数之和的思想，这里使用三层for。需要注意的是a、b的去重逻辑
     **/
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        // a+b+c+d
        for (int i = 0; i < length - 3; i++) {
            // 剪枝a
            if (nums[i] > 0 && nums[i] > target) {
                break;
            }
            // 去重a
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                // 去重b
                // 这里一定要j>i+1，因为如果>1这种，第一次就直接跳过了，要保证第一次四元组要先成功有一个结果，后面再去重。
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 赋值left和right
                int left = j + 1;
                int right = length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum + nums[i] + nums[j] > target) {  // 说明大了，right左移
                        right--;
                    } else if (sum + nums[i] + nums[j] < target) { // 说明小了，left右移
                        left++;
                    } else {
                        // 找到一个四元组
                        List<Integer> triple = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
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
        }
        return res;
    }
}
