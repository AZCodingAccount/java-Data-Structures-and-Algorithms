package com.zh.problem.doublep;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-14 20:18
 * @description: 两数之和——leetcode167
 **/
public class TwoSum {
    /*
        要求常量额外空间，使用双指针解决
     */

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (true) {
            // left>right时候没有判断，题目说不可能出现这种情况，一定有解
            int total = numbers[left] + numbers[right];
            if (total == target) {
                break;
            } else if (total < target) {  // 小了，移动左指针
                left++;
            }else
            {
                right--;
            }
        }
        return new int[]{left+1, right+1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{5,25,75}, 100)));
    }


}
