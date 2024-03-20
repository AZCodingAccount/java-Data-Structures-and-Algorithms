package com.zh.job;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-19 19:34
 * @description: 跳跃游戏2——leetcode45
 **/
public class CanJump2 {

    /*
        贪心策略是选取最大的跳跃长度

     */
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int count = 0;
        int maxStep = nums[0], stepIndex = 1;
        for (int i = 0; i < nums.length; i += stepIndex) {
            if (maxStep + i >= nums.length - 1) {
                return count + 1;
            }
            int step = 0;   // 代表能到达的最远位置
            int k = maxStep;
            for (int j = 1; j <= k; j++) {
                if (i + j < nums.length && j + nums[i + j] >= step) {    // 记录需要跳的步数和索引，步数是内循环次数、索引是外循环转移个数
                    step = j + nums[i + j];
                    maxStep = nums[i + j];  // 下次可以到达的范围
                    stepIndex = j;          // 跳跃的范围
                }
            }
            // System.out.println("maxStep: " + maxStep);
            // System.out.println("stepIndex: " + stepIndex);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CanJump2().jump(new int[]{2, 1, 1, 1, 1}));
    }
}
