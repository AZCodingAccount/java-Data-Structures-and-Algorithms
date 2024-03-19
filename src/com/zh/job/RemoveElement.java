package com.zh.job;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-19 10:32
 * @description: 面试经典150题——2
 **/
public class RemoveElement {

    /*
        直接遍历数组，覆盖元素，就可以了

     */
    public int removeElement(int[] nums, int val) {
        int p = 0;    // 元素尾指针
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[p] = nums[i];
                p++;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int n = new RemoveElement().removeElement(nums, 3);
        for (int i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }
    }

}
