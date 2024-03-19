package com.zh.job;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-19 15:37
 * @description: 删除有序数组的重复项——hot150第三题
 **/
public class RemoveDuplicates {
    /*
            快慢指针、碰到重复的只移动右指针，没有重复的把位置i的元素拷贝到新数组中,i++;j++
            0,0,1,2,2
     */
    public int removeDuplicates(int[] nums) {
        int left = 0, right = 1, k = 0;
        int[] res = new int[nums.length];
        while (right < nums.length) {
            if (nums[left] == nums[right]) {
                right++;
            } else {
                res[k++] = nums[left];
                left = right;
                right++;
            }
        }
        // 把最后的一个元素补上
        if (left < nums.length) {
            res[k++] = nums[nums.length - 1];
        }
        System.arraycopy(res, 0, nums, 0, k);
        return k;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicates(new int[]{0, 0, 1, 2, 2}));
    }
}
