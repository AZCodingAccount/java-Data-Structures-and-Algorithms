package com.zh.codetop;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-14 21:00
 * @description:
 **/
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1, right = n - 1, curr = m + n - 1;
        while (left >= 0 && right >= 0) {
            if(nums1[left]>=nums2[right]){
                nums1[curr--]=nums1[left--];
            }else{
                nums1[curr--]=nums2[right--];
            }
        }
        // nums2有剩下的
        while(right>=0) nums1[curr--]=nums2[right--];
    }
}
