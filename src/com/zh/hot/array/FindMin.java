package com.zh.hot.array;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-10 19:29
 * @description: 寻找旋转排序数组中的最小值—lc153
 **/
public class FindMin {
    /*

     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left<right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[nums.length - 1]) {
                right = mid;
            } else if (nums[mid] >= nums[0]) {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(new FindMin().findMin(new int[]{3, 4, 5, 1, 2}));
    }
}
