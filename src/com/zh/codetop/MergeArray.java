package com.zh.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-18 00:24
 * @description:
 **/
public class MergeArray {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[][]{};
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        // 使用List存储结果
        ArrayList<int[]> res = new ArrayList<>();
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= right) { // 合并
                right = Math.max(intervals[i][1], right);
            } else {  // 收集结果
                res.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        res.add(new int[]{left, right});
        return res.toArray(new int[res.size()][]);
    }
}
