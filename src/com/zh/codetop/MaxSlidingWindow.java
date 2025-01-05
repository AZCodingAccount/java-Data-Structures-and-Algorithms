package com.zh.codetop;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-12-01 12:26
 * @description:
 **/
public class MaxSlidingWindow {
    class MonoQueue {
        LinkedList<Integer> deque = new LinkedList<>();
        int[] nums;

        public MonoQueue(int[] nums) {
            this.nums = nums;
        }

        // push元素，弹出比当前元素小的元素
        public void push(int idx) {
            while (!deque.isEmpty() && deque.peekLast() < idx) {
                deque.pollLast();
            }
            deque.offerLast(idx);
        }

        // pop元素，判断最大的元素是不是相等，如果相等，就弹出
        public void pop(int val) {
            // 注意不要把值相等但是索引不同的弹出去
            if (!deque.isEmpty() && val == deque.peekFirst() ) {
                deque.pollFirst();
            }
        }

        // getMaxVal，获取队列第一个元素
        public int getMaxVal() {
            return deque.peekFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        MonoQueue monoQueue = new MonoQueue(nums);
        for (int i = 0; i < k; i++) {
            monoQueue.push(nums[i]);
        }
        res[0] = monoQueue.getMaxVal();
        for (int i = 0; i < nums.length - k; i++) {
            monoQueue.pop(nums[i]); // 弹出之前的
            monoQueue.push(nums[i + k]);    // 加上新的
            res[i + 1] = monoQueue.getMaxVal();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MaxSlidingWindow().maxSlidingWindow(new int[]{-7, -8, 7, 5, 7, 1, 6, 0}, 4)));
    }
}
