package com.zh.job.greedy;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-20 16:34
 * @description: 跳跃游戏—lc55
 **/
public class CanJump {
    /*
        每次跳到可跳步数最多的格子，写的一坨屎，中间好多0的情况处理不了。贪心思路是尽可能跳的最远，中间有能跳到最远的就换车

     */
    public boolean canJump(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            int step = nums[i];
            int jumpIndex = 0;  // 要跳到的索引，初始化没啥用
            if (step == 0 && i == nums.length - 1) {
                return true;
            }
            if (step == 0 && i != nums.length - 1) {
                return false;
            }
            // 求出来可跳的最多步数的索引
            while (step > 0) {
                int newIndex = i + nums[i] - step + 1;
                if (newIndex < nums.length-1) {
                    if (step == nums[i]) {  // 第一次进来时
                        jumpIndex = newIndex;
                    } else// 后序进行比较
                        if (nums[jumpIndex] <= nums[newIndex]) {
                            jumpIndex = newIndex;
                        }
                } else {  // 都能跳出去了，return true即可
                    return true;
                }
                step--;
            }

            i = jumpIndex;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new CanJump().canJump(new int[]{4,2,0,0,1,1,4,4,4,0,4,0}));
    }
}
