package com.zh.problem.doublep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-16 14:57
 * @description: 滑动窗口最大值——leetcode239
 **/
public class MaxSlidingWindow {

    /*
            暴力会超时，使用单调队列。思路如下
            1：定义两个指针i=0,j=k-1，取出队头元素
            2：i++，j++，按照单调队列的规则入队一个元素，检查当前队列长度是否大于K，如果大于，将窗口外的元素出队，并取出队头元素存入List。
            3：重复以上步骤，直到j>=nums.length-1
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0, j = k - 1;
        LinkedList<Integer> deque = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for (int i1 = 0; i1 < k; i1++) {
            // 新增元素
            while (deque.peekLast() != null && deque.peekLast() < nums[i1]) {
                deque.pollLast();
            }
            deque.addLast(nums[i1]);
        }
        res.add(deque.peekFirst());
        System.out.println(deque.peekFirst());
        // 3    3   5   5   6   7
        //      i       j
        // 开始寻找后面的元素
        while (j < nums.length - 1) {
            i++;
            j++;
            // 新增元素
            while (deque.peekLast() != null && deque.peekLast() < nums[j]) {
                deque.pollLast();
            }
            deque.addLast(nums[j]);
            System.out.println(deque.peekFirst());
            res.add(deque.peekFirst());

            // 移除可能不在队列中的元素
            if (nums[i - 1] == deque.peekFirst()) {
                deque.pollFirst();
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MaxSlidingWindow().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
