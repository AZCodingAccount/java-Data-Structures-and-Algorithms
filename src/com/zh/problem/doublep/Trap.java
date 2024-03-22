package com.zh.problem.doublep;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-16 15:59
 * @description: 接雨水——leetcode42
 **/
public class Trap {
    /*
        单调栈问题。
        1：问题1在于栈里面存储的是什么元素，显然存储的是待处理的元素，等待后面的元素对这些压缩进行处理
        1：问题2在于何时计算柱子中水的面积？答案是当遇到待压入的元素大于栈顶的元素时。碰到第一个大于或等于当前元素的height时停止
     */

    public int trap(int[] height) {
        LinkedList<Pillar> stack = new LinkedList<>();  // 单调栈，存储待处理的元素
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty() || stack.peek().height > height[i]) {
                // 可以新增元素
                stack.push(new Pillar(i, height[i]));
            } else {  //  开始处理栈中元素
                while (!stack.isEmpty() && stack.peek().height < height[i]) {   // 开始处理栈里面的元素
                    Pillar pop = stack.pop();   // 要处理的中间元素
                    Pillar left = stack.peek(); // 当前处理的元素
                    if (left != null) { // 计算面积，如果没有待处理的元素，不处理
                        int area = (i - left.index - 1) * (Math.min(left.height, height[i]) - pop.height);
                        sum += area;
                    }
                }
                stack.push(new Pillar(i, height[i]));   // 处理完毕把当前元素压入栈中
            }
        }

        return sum;
    }

    // 索引+高度
    static class Pillar {
        int index;
        int height;

        public Pillar(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Trap().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
