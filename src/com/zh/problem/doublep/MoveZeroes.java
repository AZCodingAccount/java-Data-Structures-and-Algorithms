package com.zh.problem.doublep;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-04-24 21:49
 * @description: 移动零——lc283
 **/
public class MoveZeroes {
    /*                                                                             j               i j
            本题的核心逻辑是把非0元素全部移动到前面且保持相对顺序即可（不要关心0）    [1,1,0,0,3,12]——>[1,1,3,0,12]
            快慢指针i和j，慢指针i左边都是处理好的元素，快指针j去找不是0的元素进行交换。j>=nums.length结束
            [1,2]
     */
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (i < nums.length && j < nums.length) {
            // 移动i指针，寻找0元素
            while (i < nums.length && nums[i] != 0) {
                i++;
            }
            // 移动j指针，从i开始，寻找非0元素
            j = Math.max(i, j);
            while (j < nums.length - 1 && nums[j] == 0) {
                j++;
            }
            // 交换两者元素
            if (i < nums.length && j < nums.length && nums[j] != 0 && i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            j++;
        }
    }

    /*
    第二种解法是，不用管前面的元素，不需要交换，将非0元素直接填充到前面的元素，后面的直接补0
     */
    // 1 0 3
    // 1 3 0
    public void moveZeroes1(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        // 最后给后面的元素全部填充0[i,nums.length)
        Arrays.fill(nums, i, nums.length, 0);
    }

    public static void main(String[] args) {
        // 1 0 0 3 12
        int[] nums = new int[]{1, 0};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
