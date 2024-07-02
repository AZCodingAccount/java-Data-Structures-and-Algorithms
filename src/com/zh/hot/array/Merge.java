package com.zh.hot.array;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-02 19:38
 * @description: 合并两个有序数组—lc88
 **/
public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num = new int[m + n];
        int left = 0, right = 0, curr = 0;
        while (left < m && right < n) {
            if (nums1[left] <= nums2[right]) {
                num[curr++] = nums1[left];
                left++;
            } else {
                num[curr++] = nums2[right];
                right++;
            }
        }
        if (left == m) System.arraycopy(nums2, right, num, curr, n - right);
        if (right == n) System.arraycopy(nums1, left, num, curr, m - left);
        System.arraycopy(num, 0, nums1, 0, m + n);
    }
}
