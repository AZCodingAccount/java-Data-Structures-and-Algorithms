package com.zh.job.queue;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-17 17:53
 * @description: 滑动窗口最大值—lc239
 **/
public class MaxSlidingWindow {
    /**
     * 单调栈。使用一个双向队列实现，push时候清除前面比该元素小的元素，并且pool时候要判断左指针前面的那个元素是不是当前单调队列中的最大值
     * 简单来说，这个单调栈维护的是长度是<=k的
     **/
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int p = 0;

        for (int i = 0; i < nums.length; i++) {
            // 首先push元素，push元素时要弹出小元素
            while (!deque.isEmpty()) {
                Integer last = deque.peekLast();
                if (last < nums[i]) {
                    deque.pollLast();  // 弹出之前元素
                } else {
                    break;
                }
            }
            deque.offerLast(nums[i]);   // 老老实实加进去

            // 看看队头元素需不需要出队，这里就用这个相等判断就行，因为之前去除比offer进来的元素大的时候允许重复了，所以不会误删
            // 当然，这里也可以根据下标删除，就是deque里面存的是下标不是值了
            if (i >=k && nums[i - k] == deque.peekFirst()) {
                deque.pollFirst();
            }

            // 到点了可以添加到结果里面了
            if (i >= k - 1) {
                res[p++] = deque.peekFirst();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MaxSlidingWindow().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
