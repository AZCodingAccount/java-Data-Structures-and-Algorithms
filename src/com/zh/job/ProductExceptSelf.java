package com.zh.job;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-20 14:59
 * @description: 除自身外所有数组元素的乘积——leetcode238
 **/
public class ProductExceptSelf {
    /*
        方案1：暴力，双层for
        方案2：计算出所有数组元素的乘积sum、计算时候除以nums[i]
        方案3：记录计算过的元素的前缀和后缀。L、R  时间复杂度O(n)、LR必须是数组，因为不能使用除法
        L: 存储前i个元素的乘积       L(0)=1
        R: 存储i到数组末尾的乘积     L(nums.length-1)=1
        时间复杂度分析：初始化过程2*n, 一次遍历n，时间复杂度O(n)、空间复杂度O(n)
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // 注意不包含i
        int[] L = new int[n];   // 存储前i个元素的乘积
        int[] R = new int[n];   // 存储i到数组末尾的乘积
        L[0] = 1;
        R[n - 1] = 1;

        // 初始化
        for (int i = 1; i < nums.length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }
        int[] res = new int[nums.length];

        // 计算
        for (int i = 0; i < nums.length; i++) {
            res[i] = L[i] * R[i];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ProductExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
