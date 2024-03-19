package com.zh.job;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-19 16:54
 * @description: 轮转
 **/
public class Rotate {
    /*
        1：最直观的说法，就是交换，注意加上k以后求余,但是需要考虑不会把要交换的元素给覆盖了，这就需要一个prev保存一下 时间复杂度O(n) 空间复杂度O(1)
        2：增加nums的长度，这样直接+就可以
     */
    public void rotate(int[] nums, int k) {
        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            // 外层循环确保遍历完
            int curr = i;   // 当前指针
            int prev = nums[i]; // 被替换的元素
            // 比如 0 1 2 3 4 5  k=2
            // 过程是两轮(6和2的最大公约数是2)：
            // 0——>2    2——>4   4——>0
            // 1——>3    3——>5   5——>1
            do {
                // 替换，更新指针
                int temp=nums[(curr + k) % nums.length];    // 保存当前被覆盖的元素
                nums[(curr + k) % nums.length] = prev;
                prev = temp; // 保存当前结果
                curr = (curr + k) % nums.length;
                count++;
            } while (curr != i);  // 回不到原点结束
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        new Rotate().rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
