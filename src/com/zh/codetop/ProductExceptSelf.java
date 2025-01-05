package com.zh.codetop;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-12-03 23:35
 * @description:
 **/
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] L = new int[len];
        int[] R = new int[len];
        // 预处理
        int preSum = 1;
        for (int i = 0; i < len; i++) {
            preSum *= nums[i];
            L[i] = preSum;
        }
        preSum = 1;
        for (int i = len - 1; i >= 0; i--) {
            preSum *= nums[i];
            R[i] = preSum;
        }
        int[] res = new int[len];
        // 求和
        for (int i = 0; i < len; i++) {
            int leftSum = i - 1 < 0 ? 1 : L[i - 1];
            int rightSum = i + 1 >= len ? 1 : R[i + 1];
            res[i] = leftSum * rightSum;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ProductExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
