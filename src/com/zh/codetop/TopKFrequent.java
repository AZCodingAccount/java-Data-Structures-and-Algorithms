package com.zh.codetop;

import java.util.*;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-10-22 23:33
 * @description: 前K个高频元素-lc347
 **/
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 统计元素
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        // 存储元素
        PriorityQueue<Map<Integer, Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.values().iterator().next() - o1.values().iterator().next());

        for (Integer key : map.keySet()) {
            HashMap<Integer, Integer> e = new HashMap<>();
            e.put(key, map.get(key));
            priorityQueue.offer(e);
        }

        // 取出k个元素
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            if (priorityQueue.peek() != null) {
                res[i] = priorityQueue.poll().keySet().iterator().next();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TopKFrequent().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}
