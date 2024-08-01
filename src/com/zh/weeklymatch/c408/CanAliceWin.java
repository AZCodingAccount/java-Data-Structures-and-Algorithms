package com.zh.weeklymatch.c408;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-28 10:40
 * @description: 判断是否可以赢得数字游戏—408周赛第一题
 **/
public class CanAliceWin {
    public boolean canAliceWin(int[] nums) {
        int sum = 0, sum1 = 0, sum2 = 0;
        for (int num : nums) {
            sum += num;
            if (num >= 0 && num <= 9) sum1 += num;
            else if (num >= 10 && num <= 99) sum2 += num;
        }
        return (sum1 > sum - sum1) || (sum2 > sum - sum2);
    }
}
