package com.zh.job.origin;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-19 19:20
 * @description: 跳跃游戏——leetcode55
 **/
public class CanJump {

    /*
            贪心思想，别管最后能不能到，这一步先跳了再说，如果途中有能跳更多步的，就果断换车
     */
    public boolean canJump(int[] nums) {
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            step = Math.max(nums[i], step);
            if (i >= nums.length - 1) {
                return true;    // 说明已经跳到最后了
            }
            if (step == 0 ) {
                return false;   // 说明最后跳不过去了
            }
            step--;
        }
        return true;    // 通过了校验
    }

    public static void main(String[] args) {
        System.out.println(new CanJump().canJump(new int[]{2, 3, 1, 0, 4}));
    }
}
