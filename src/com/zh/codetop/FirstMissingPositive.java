package com.zh.codetop;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-12-01 13:41
 * @description:
 **/
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        // 第一轮循环尝试把数放在他应该放在的位置上
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 当前处理的是nums[i]，要考虑已经放在了正确的位置上
            while (nums[i] >= 1 && nums[i] <= len && nums[i] - 1 != i) {
                if (nums[nums[i] - 1] == nums[i]) break;
                swap(nums, nums[i] - 1, i);
            }
        }
        // 接下来遍历一遍，看看有没有放好
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    private void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
}
