package com.zh.problem.doublep;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-04-24 21:49
 * @description: 移动零——lc283
 **/
public class MoveZeroes {
    /*
            本题的核心逻辑是把非0元素全部移动到前面且保持相对顺序即可（不要关心0）    [1,1,0,3,12]
            快慢指针i和j，慢指针i左边都是处理好的元素，快指针j去找不是0的元素进行交换。j>=nums.length结束
     */
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length - 1) {
            // 移动i和j指针
            while (nums[i] != 0 && j < nums.length - 2) {
                i++;
                j++;
            }
            j++;
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
