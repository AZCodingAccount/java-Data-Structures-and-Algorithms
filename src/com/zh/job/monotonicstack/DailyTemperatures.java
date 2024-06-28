package com.zh.job.monotonicstack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-28 20:18
 * @description: 每日温度—lc739
 **/
public class DailyTemperatures {
    /*
        单调栈典型应用题目，明确自己的栈是单调递增还是单调递减的，这里由于求比当前元素大的，所以是单调递增的（栈顶最小）
     */

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];  // 结果集
        LinkedList<Integer> stack = new LinkedList<>();   // 单调栈容器
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            Integer peeked = stack.peek();
            // noinspection DataFlowIssue
            if (temperatures[i] > temperatures[peeked]) {
                // 把能处理的元素全处理了
                while (peeked != null && temperatures[i] > temperatures[peeked]) {
                    res[peeked] = i - peeked;   // 记录结果
                    stack.pop();    // 当前元素已处理
                    peeked = stack.peek();  // 更新peeked
                }
                stack.push(i);  // 加入新元素
            } else {  // 栈顶元素大于等于当前处理元素
                stack.push(i);  // 加入当前元素，等待处理
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}

