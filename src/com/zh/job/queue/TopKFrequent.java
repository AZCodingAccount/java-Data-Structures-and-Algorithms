package com.zh.job.queue;

import java.util.*;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-17 18:30
 * @description: 前K个高频元素—lc347
 **/
public class TopKFrequent {
    /**
     * 首先统计一下，使用哈希表O(n)，再加入到优先级队列O(nlog(n))，最后取出k个元素
     **/
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 计算
        for (int num : nums) {
            map.compute(num, (key, oldVal) -> oldVal == null ? 1 : oldVal + 1);
        }
        PriorityQueue<Map<Integer, Integer>> queue = new PriorityQueue<>(k,(m1, m2) -> {
            Integer value1 = m1.values().iterator().next();
            Integer value2 = m2.values().iterator().next();
            return value2.compareTo(value1);
        });
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            hashMap.put(key, value);
            queue.offer(hashMap);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            for (Integer key : queue.poll().keySet()) {
                res[i] = key;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TopKFrequent().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}
