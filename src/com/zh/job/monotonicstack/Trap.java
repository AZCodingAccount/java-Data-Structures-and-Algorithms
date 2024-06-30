package com.zh.job.monotonicstack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-30 14:56
 * @description: 接雨水—lc42
 **/
public class Trap {
    /*
        维护一个单调递增栈，遇到比栈顶元素大的情况下计算面积
     */
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                Integer curr = stack.pop();     // 当前正在处理的元素
                if (stack.isEmpty()) {    // 兼容中间没有凹槽的情况
                    break;
                }
                Integer left = stack.peek(); // 取出元素的左端点，注意，这个端点还没有被处理，不要弹出
                Integer right = i;
                int h = Math.min(height[left], height[right]) - height[curr]; // 计算高度
                int w = right - left - 1;   // 计算宽度
                res += h * w;
            }
            // 当前元素小于栈顶元素或者已经处理完前面比它小的元素，加入到栈中
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Trap().trap(new int[]{4, 2, 0, 3, 2, 5}));
    }
}
