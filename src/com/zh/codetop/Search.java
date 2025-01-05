package com.zh.codetop;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-13 23:42
 * @description: 搜索旋转排序数组
 **/
public class Search {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = right + (left - right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] >= nums[left]) {   // 落在左边这个数组上
                if (nums[mid] > target && target >= nums[left]) {   // 在左边
                    right = mid - 1;
                } else {  // 在右边
                    left = mid + 1;
                }
            } else {  // 落在右边这个数组上
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
