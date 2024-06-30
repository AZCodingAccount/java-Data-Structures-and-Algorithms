package com.zh.job.monotonicstack;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-30 15:45
 * @description: 柱状图中最大的矩形—lc84
 **/
public class LargestRectangleArea {
    /*
        使用单调递减栈，每次碰到比栈顶元素小的元素就处理单调栈的这个元素。需要注意的是处理的不是当前遍历的这个元素，而是栈顶元素
     */
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        // 前后添加一个0可以不用特殊处理 2 4 6 8 和 8 2 6 4这两种情况
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[heights.length + 1] = 0;
        System.arraycopy(heights, 0, newHeights, 1, newHeights.length - 1 - 1);
        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[i] <= newHeights[stack.peek()]) {    // 当前元素小了收集结果，这里
                Integer curr = stack.pop(); // 当前处理的元素
                if (!stack.isEmpty()) { // 可以不判断，用来兼容没有左边最小值的情况
                    Integer left = stack.peek();    // 小于当前元素的索引
                    Integer right = i;
                    int width = right - left - 1;   // 宽
                    int height = newHeights[curr];     // 高
                    res = Math.max(res, width * height);
                }
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LargestRectangleArea().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
