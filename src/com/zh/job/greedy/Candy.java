package com.zh.job.greedy;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-20 20:35
 * @description: 分发糖果—lc135
 **/
public class Candy {
    /*
        要求比左边大和比右边大，不要一起比较，先确定一边。（真的很重要！刷题时候往往留给下一次去处理）
     */

    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        int sum = 0;
        // 先关心右边比左边大的孩子分发糖果
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // 再关心左边比右边大的孩子分发糖果，一定从反方向，不然之前的结果就利用不了了，我们之前已经从前往后过了
        // 2 5 4 3  排名
        // 1 2 2 2  第一轮遍历，从前往后
        // 1 2 2 2  第二轮遍历，从前往后遍历
        // 1 3 2 1  第二轮遍历，这个是对的，从后往前遍历
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);   // 取一个较大值，综合左边和右边
            }
            sum += candies[i];
        }
        // 加上最后一个
        sum += candies[ratings.length - 1];
        return sum;
    }
}
