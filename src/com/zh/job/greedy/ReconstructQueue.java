package com.zh.job.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-21 21:34
 * @description: 根据身高重建队列—lc406
 **/
public class ReconstructQueue {
    /*
        首先根据身高排序，然后根据k的值插入到数组的k位置后面
     */

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o2[0] - o1[0];
            }
        });
        List<int[]> result = new ArrayList<>();
        for (int[] person : people) {
            result.add(person[1], person);
        }

        return result.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new ReconstructQueue().reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}})));
    }
}
