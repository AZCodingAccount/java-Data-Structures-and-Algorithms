package com.zh.hot.array;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-02 16:13
 * @description: 搜索旋转排序数组—lc33
 **/
public class Search {
    /*
        旋转一次，就分成了两个单调递增的区间，且前面的比后边的要大，注意这个特性，用于判断每次二分的结果在哪个区间
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] >= nums[left]) { // 落在了左区间
                if (target < nums[mid] && target >= nums[left]) {  // 在左区间的左边
                    right = mid - 1;
                } else {    // 在左区间的右边
                    left = mid + 1;
                }
            } else {  // 落在了右区间
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
