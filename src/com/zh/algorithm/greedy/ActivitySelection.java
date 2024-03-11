package com.zh.algorithm.greedy;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-11 10:30
 * @description: 活动选择问题
 **/
public class ActivitySelection {
    /*
                贪心问题，贪心策略是为了给剩下的活动留下尽可能多的使用时间。以此达到目标，举办的活动次数最多
            每次选择活动结束时间最早的活动，直到遍历到最后
     */

    static class Activity {
        String name;    // 活动名
        int from;       // 活动开始时间
        int to;         // 活动结束时间

        public Activity(String name, int from, int to) {
            this.name = name;
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Activity[] activities = new Activity[]{
                new Activity("A", 2, 4),
                new Activity("B", 1, 3),
                new Activity("C", 3, 5)};

        // 将活动根据结束时间升序排列    B A C
        Arrays.sort(activities, Comparator.comparingInt(a -> a.to));

        Activity prevActivity = null; // 记录前一个活动

        List<Activity> arrangeActivities = new ArrayList<>(); // 存储安排的集合

        for (Activity activity : activities) {
            if (prevActivity != null && prevActivity.to > activity.from) {
                // 冲突了，什么也不做
                continue;
            } else {  // 没有冲突，添加活动，设置前一个活动
                arrangeActivities.add(activity);
                prevActivity = activity;
            }
        }



        System.out.println(arrangeActivities);
    }
}
