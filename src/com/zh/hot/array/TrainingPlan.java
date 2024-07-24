package com.zh.hot.array;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-24 21:12
 * @description: 训练计划1—lcr139
 **/
public class TrainingPlan {
    public int[] trainingPlan(int[] actions) {
        int len = actions.length;
        if (len <= 1) return actions;
        int odd = 0, even = 0;
        while (odd < len && even < len) {
            while (odd < len - 1 && actions[odd] % 2 == 0) odd++;   // 找到第一个为奇数的
            while(even < len - 1 && actions[even] % 2 != 0) even++; // 找到第一个为偶数的
            // 交换并应付下一次迭代
            if (odd > even) {
                int temp = actions[odd];
                actions[odd] = actions[even];
                actions[even] = temp;
                even++;
            }
            odd++;  // 无论打不达到交换的结果就去找奇数
        }
        return actions;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TrainingPlan().trainingPlan(new int[]{1, 2, 3, 4, 5})));
    }
}
