package com.zh.job.greedy;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-22 20:12
 * @description: 无重叠区间—lc435
 **/
public class EraseOverlapIntervals {
    /*
        我猜测是按照起始索引排序，然后搜索，跟射箭一个思路
     */

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int res = 0;
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {    // 说明必须移除一个数组了
                res++;
                // 这么理解，可以删除当前的数组，也可以删除后面的数组，只要使得后面的空间尽量多一点。
                intervals[i + 1][1] = Math.min(intervals[i][1], intervals[i + 1][1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new EraseOverlapIntervals().eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
    }
}
