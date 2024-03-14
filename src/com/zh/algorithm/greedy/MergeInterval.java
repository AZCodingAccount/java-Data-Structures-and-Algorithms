package com.zh.algorithm.greedy;

import java.util.*;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-11 10:55
 * @description: 合并区间——leetcode74题
 **/
public class MergeInterval {
    /*
            以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi]。
        请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。

        （覆盖重叠的区间数组），步骤如下：
            1：对输入的数组进行排序，按照数组的start时间排序
            2：定义一个暂存数组tempIntervals初始化为数组第1项
            3；从索引1遍历数组
                1：冲突，合并。写入新数组中
                2：不冲突，改变tempIntervals，写入新数组中，继续遍历
     */

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);


        LinkedList<int[]> resultIntervals = new LinkedList<>();
        int[] tempIntervals = intervals[0];   // 暂存数组，方便数组合并
        resultIntervals.push(tempIntervals.clone());    // 处理第一个元素

        // 遍历数组
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= tempIntervals[1]) {
                // 冲突，合并
                tempIntervals[1] = Integer.max(intervals[i][1], tempIntervals[1]);
                resultIntervals.poll(); // 弹出上一个加入的
                resultIntervals.push(tempIntervals.clone());
            } else {
                // 不冲突，改变tempInterval
                tempIntervals[0] = intervals[i][0];
                tempIntervals[1] = intervals[i][1];
                resultIntervals.push(tempIntervals.clone());
            }
        }
        return resultIntervals.stream()
                .sorted((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0])
                .toArray(int[][]::new);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 4}, {2, 3}};
        System.out.println(Arrays.deepToString(new MergeInterval().merge(intervals)));
    }
}
