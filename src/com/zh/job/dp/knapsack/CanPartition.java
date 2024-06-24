package com.zh.job.dp.knapsack;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-22 21:04
 * @description: 分割等和子集—lc416
 **/
public class CanPartition {
    /*
            分割等和子集，问是否可以将这个数组分割成两个子集，使得两个子集的元素和相等，可以抽象成一个0-1背包问题的变种。
        为什么说是变种，因为之前是求最大价值，现在求最大容量即可
        这么多个物品，是否可以将重量为数组之和一半的背包装满。动规五部曲，我使用一维DP解
        dp[i]代表容量为i的背包能装的最大重量（重量跟i相等，就可以返回true了）
        dp[i]=max(dp[i],dp[i-w(i)])  如果装的下的话，考虑装或不装。装不下，就是简单的dp[i]
        初始化都初始化成0即可
        遍历还是上面物品，下面元素个数，注意倒序，从nums[i]—>0
     */
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) { // 不可能存在相加有小数的情况
            return false;
        }
        int capacity = sum / 2;
        int[] dp = new int[capacity + 1];

        for (int num : nums) {  // 外层是物品，元素个数
            for (int j = capacity; j >= num; j--) { // 内层是背包容量
                if (dp[j] == capacity) {
                    return true;
                }
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new CanPartition().canPartition(new int[]{1, 2, 3, 5}));
    }
}
