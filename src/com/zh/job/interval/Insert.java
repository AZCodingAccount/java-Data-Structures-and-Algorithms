package com.zh.job.interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-04-10 14:15
 * @description: 插入区间——lc57
 **/
public class Insert {
    /*
                易知，一共有两种情况。
                [1,2] [5,6] [3,4]
            1：插入newInterval，不需要合并区间。思路是newInterval[0]>intervals[i][1] && newInterval[1]<intervals[i+1][0]
            2：需要合并区间，合并一个或多个区间
                合并一个区间 [1,3] [6,8] 插入 [2,5]——>[1,5] 具体在于下一个区间的start小于两个区间最大的end
                合并多个区间  
     */

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};
        }
        List<int[]> newIntervals = new ArrayList<>();
        // 处理特殊情况，intervals只有一个数组
        if (intervals.length == 1 && intervals[0][0] <= newInterval[0]) {
            newIntervals.add(new int[]{intervals[0][0], intervals[0][1]});
            newIntervals.add(new int[]{newInterval[0], newInterval[1]});
        } else if (intervals.length == 1) {
            newIntervals.add(new int[]{newInterval[0], newInterval[1]});
            newIntervals.add(new int[]{intervals[0][0], intervals[0][1]});
        } else {
            boolean isInserted = false; // 标记是否插入
            // 添加插入的区间
            for (int i = 0; i < intervals.length-1; i++) {
                // 添加到中间
                if (intervals[i][0] <= newInterval[0] && intervals[i + 1][0] >= newInterval[0] && !isInserted) {
                    newIntervals.add(new int[]{intervals[i][0], intervals[i][1]});
                    newIntervals.add(new int[]{newInterval[0], newInterval[1]});
                    isInserted = true;
                } else if (intervals[i][0] > newInterval[0] && !isInserted) {  // 插入到刚开始
                    newIntervals.add(new int[]{newInterval[0], newInterval[1]});
                    newIntervals.add(new int[]{intervals[i][0], intervals[i][1]});
                    isInserted = true;
                } else {    // 正常添加区间
                    newIntervals.add(new int[]{intervals[i][0], intervals[i][1]});
                }
            }
            newIntervals.add(new int[]{intervals[intervals.length-1][0], intervals[intervals.length-1][1]});
            if(intervals[intervals.length-1][0] < newInterval[0]){
                newIntervals.add(new int[]{newInterval[0], newInterval[1]});
            }
        }
        List<int[]> res = new ArrayList<>();

        // 按照区间排序 合并后区间的左边界  合并后区间的右边界
        int i = 0, left = newIntervals.get(0)[0], right = newIntervals.get(0)[1];
        while (i < newIntervals.size() - 1) {
            // 判断下一个区间是否可以合并
            if (right >= newIntervals.get(i + 1)[0]) { // 第一个的右边界大于第二个的左边界
                // 更新left和right
                left = Math.min(left, newIntervals.get(i + 1)[0]);
                right = Math.max(right, newIntervals.get(i + 1)[1]);
            } else {  // 加入结果数组中
                res.add(new int[]{left, right});
                // 更新left和right
                left = newIntervals.get(i + 1)[0];
                right = newIntervals.get(i + 1)[1];
            }
            i++;
        }
        res.add(new int[]{left, right});
        return res.toArray(int[][]::new);
    }

    public static void main(String[] args) {
        new Insert().insert(new int[][]{{2, 5}, {6, 7}, {8, 9}}, new int[]{0, 1});
    }
}
