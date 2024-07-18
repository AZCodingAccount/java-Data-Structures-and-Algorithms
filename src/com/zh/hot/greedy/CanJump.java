package com.zh.hot.greedy;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-18 18:51
 * @description: 跳跃游戏—lc55
 **/
public class CanJump {

    public boolean canJump(int[] nums) {
        if (nums.length == 0) return false;
        int step = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (--step < 0) return false;
            step = Math.max(step, nums[i]);
        }
        return true;
    }
}
