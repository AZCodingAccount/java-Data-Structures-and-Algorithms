package com.zh.codetop;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-17 23:53
 * @description: 单调栈
 **/
public class Trap {
    public int trap(int[] height) {
        LinkedList<Integer> stack = new LinkedList<>();
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {   // 计算结果
                Integer curr = stack.pop();
                if (stack.isEmpty()) break;
                int left = stack.peek();
                int w = i - left - 1;
                int h = Math.min(height[i], height[left]) - height[curr];
                area += w * h;
            }
            stack.push(i);
        }
        return area;
    }
}
