package com.zh.job.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-25 19:45
 * @description: 合并区间—lc56
 **/
public class Merge {
    /*
    一个经典的思路，先按照起始位置排序，然后遍历数组，如果有重叠区间继续遍历，如果没有就加入结果集。
    也可以使用deque，不断的更新放进来的新区间，注意这里，也就意味着头元素需要特殊处理，并且不需要left和right
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[][] res = new int[intervals.length][2];

        int left = intervals[0][0]; // 左端点
        int right = intervals[0][1];    // 右端点
        int k = 0;    // 结果数组索引
        for (int i = 0; i < intervals.length - 1; i++) {
            // 注意从0—len-1,因为这样判断当前索引后面的，这样left和right赋值的时候可以简单点
            if (right >= intervals[i + 1][0]) { // 右区间大于新区间的左端点，可以合并
                right = Math.max(intervals[i + 1][1], right);
                left = Math.min(left, intervals[i + 1][0]);
            } else {  // 收集结果，并重置left和right
                res[k++] = new int[]{left, right};
                left = intervals[i + 1][0];
                right = intervals[i + 1][1];
            }
        }
        res[k] = new int[]{left, right};
        // 求出res的有效索引范围
        int j = 1;
        for (int i = 1; i < res.length; i++) {
            if (res[i][0] != 0) {
                j++;
            }
        }
        return Arrays.copyOf(res, j);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Merge().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }
}
