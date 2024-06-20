package com.zh.job.greedy;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-20 21:08
 * @description: 柠檬水找零—lc860
 **/
public class LemonadeChange {
    /*
           用到了贪心的思想，20元的时候，从大到小找
     */

    public boolean lemonadeChange(int[] bills) {
        int fiveCounts = 0;
        int tenCounts = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fiveCounts += 1;
            } else if (bill == 10) {
                if (fiveCounts < 1) {
                    return false;
                }
                tenCounts ++;
                fiveCounts--;
            } else {
                if ((tenCounts >= 1 && fiveCounts >= 1)) {
                    tenCounts--;
                    fiveCounts--;
                } else if (fiveCounts >= 3) {
                    fiveCounts -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
