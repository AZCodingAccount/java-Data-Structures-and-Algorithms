package com.zh.hot.other;


import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-13 20:39
 * @description: 丑数2—lc264
 **/
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        PriorityQueue<Long> heap = new PriorityQueue<>((Comparator.comparingLong(o -> o)));   // 小顶堆
        HashSet<Long> set = new HashSet<>();
        List<Integer> list = List.of(2, 3, 5);
        for (Integer i : list) {
            heap.offer(Long.valueOf(i));
            set.add(Long.valueOf(i));
        }
        long res = heap.peek();
        for (int i = 2; i <= n; i++) {
            res = heap.poll();   // 弹出第n个
            set.remove(res);
            // 把其他的加入到优先级队列中
            for (Integer integer : list) {
                if (!set.contains(res * integer)) {     // 去重2*3或3*2
                    set.add(res * integer);
                    heap.offer(res * integer);
                }
            }
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new NthUglyNumber().nthUglyNumber(2));
    }
}
