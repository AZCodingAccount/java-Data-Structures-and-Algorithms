package com.zh.exam;

import com.zh.datastructures.tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int search(int[] nums, int target) {
        int len=nums.length,left=0,right=len-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            // 落到了左边
            if(nums[mid]==target) return mid;
            if(nums[mid]>=nums[0]){
                if(nums[mid]>target){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{  // 落到了右边
                if(nums[mid]>target){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{4,5,6,7,0,1,2},0));
    }
}