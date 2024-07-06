package com.zh.hot.array;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-06 16:29
 * @description: 缺失的第一个正数—lc41
 **/
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 扫第一遍交换元素位置到自己的索引+1处，如果元素不在[1,n]范围内，或者两个交换的元素相等，跳过
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] <= n && nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1]) break;    // 防止死循环，交换原始已经没有实际意义了
                // 不停交换元素到合适的地方
                swap(i, nums[i] - 1, nums);
            }
        }
        // 再从前往后扫一遍看看哪个小可爱没有乖乖坐好
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return -1;
    }

    private void swap(int m, int n, int[] nums) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }
}
