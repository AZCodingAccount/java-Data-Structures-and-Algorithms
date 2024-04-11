package com.zh.job.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-04-10 12:37
 * @description: 合并区间——lc56
 **/
public class Merge {
    /*
            为什么按照左端点排序而不是右端点？比如 [1,1] [0,2] [-1,3]  如果使用右端点排序这个怎么进行合并呢，
        因为题目要求是[0,2]这种可以包括[0,2] [1,1]
     */

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0])); // 排序
        List<List<Integer>> res = new ArrayList<>();
        // 按照区间排序 合并后区间的左边界  合并后区间的右边界
        int i = 0, left = intervals[0][0], right = intervals[0][1];
        while (i < intervals.length - 1) {
            // 判断下一个区间是否可以合并
            if (right >= intervals[i + 1][0]) { // 第一个的右边界大于第二个的左边界
                // 更新left和right
                left = Math.min(left, intervals[i + 1][0]);
                right = Math.max(right, intervals[i + 1][1]);
            } else {  // 加入结果数组中
                List<Integer> r = new ArrayList<>();
                r.add(left);
                r.add(right);
                res.add(r);
                // 更新left和right
                left = intervals[i + 1][0];
                right = intervals[i + 1][1];
            }
            i++;
        }
        List<Integer> r = new ArrayList<>();
        r.add(left);
        r.add(right);
        res.add(r);
        return res.stream()
                .map(row -> row.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Merge().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }
}
