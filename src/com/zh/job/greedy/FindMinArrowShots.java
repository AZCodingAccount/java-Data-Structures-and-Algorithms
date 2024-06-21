package com.zh.job.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-21 20:57
 * @description: 用最少数量的箭引爆气球—lc452
 **/
public class FindMinArrowShots {
    /*
        简单来说，就是合并子连续数组。按照起始来排序，
        每次能续上就续，续不上就新开一个箭。但是续的时候要考虑后面能不能续上，就是更新右边界的值
        为什么不按照结束排序？考虑[1,2] [4,12],[2,13]，本来是可以完美覆盖的，结果如果现在覆盖不了了
     */

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int res = 1;
        for (int i = 1; i < points.length; i++) {
            int[] curr = points[i];
            int[] pre = points[i - 1];
            if (curr[0] > pre[1]) { // 左边大于右边
                res++;
            } else {    // 两者重叠了，更新一下当前元素的右边界的值，继续下一次遍历
                curr[1] = Math.min(curr[1], pre[1]);
            }
        }
        return res;
    }
}
