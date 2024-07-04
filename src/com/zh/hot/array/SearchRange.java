package com.zh.hot.array;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-04 15:04
 * @description: 二分查找升级版
 **/
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) { // 寻找最左边和最右边的
                int l = mid, r = mid;
                while (l >= 0 && nums[l] == target) {
                    l--;
                }
                while (r <= nums.length - 1 && nums[r] == target) {
                    r++;
                }
                return new int[]{l + 1, r - 1};
            }
            if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return new int[]{-1, -1};
    }
}
