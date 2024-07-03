package com.zh.hot.array;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-03 16:06
 * @description: 最接近的三叔之和
 **/
public class ThreeSumClosest {
    /*
        去重不去重没影响，反而慢了一点，注意bc去重时的判断条件
     */

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int fixedNum = nums[i];
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // a去重
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + fixedNum;
                if (sum > target) { // 和大了一点
                    right--;
                    if (sum - target < Math.abs(res - target))
                        res = sum;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                } else if (sum < target) { // 和小了一些
                    left++;
                    if (target - sum < Math.abs(res - target))
                        res = sum;
                    // b c 去重
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                } else {
                    return sum;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{-1000, -5, -5, -5, -5, -5, -5, -1, -1, -1}, -14));
    }
}
