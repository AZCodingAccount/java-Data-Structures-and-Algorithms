package com.zh.hot.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-20 16:26
 * @description: 跳跃游戏2—lc45
 **/
public class Jump2 {
    // dp[i] 代表跳到索引i位置所需要的最小步数
    // dp[i+j]=Math.min(dp[i+j],dp[i]+1)    j代表前面的跳的步数
    public int jump(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (nums[0] >= len) return 1;
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < len) dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        // System.out.println(new Jump2().jump(new int[]{2, 3, 1, 1, 4}));
        // System.out.println(new Jump2().jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println(new Jump2().jump(new int[]{0,0,0, 0, 2, 4}));
    }
}
