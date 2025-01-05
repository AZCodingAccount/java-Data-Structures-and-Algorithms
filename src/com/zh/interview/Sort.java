package com.zh.interview;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-12-27 00:25
 * @description:
 **/
public class Sort {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums,0,nums.length-1);
        return nums[nums.length-k];
    }

    public void quickSort(int[] nums,int left,int right){
        if(left>=right) return;
        int idx=partition(nums,left,right);
        quickSort(nums,left,idx-1);
        quickSort(nums,idx+1,right);
    }
    public int partition(int[] nums,int left,int right){
        // [left,right]
        int randomIdx=(int)(Math.random()*(right-left))+left;
        swap(nums,left,randomIdx);
        int i=left+1,j=right,pivot=nums[left];
        while(i<=j){
            // 找到第一个比基准点大的元素
            if(i<=j&&nums[i]<pivot){
                i++;
            }
            // 找到第一个小的
            if(i<=j&&nums[j]>pivot){
                j--;
            }
            if(i<=j){
                swap(nums,i,j);
                i++;
                j--;
            }
        }
        swap(nums,left,j);
        // 直到放到正确的位置了
        return j;
    }

    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
