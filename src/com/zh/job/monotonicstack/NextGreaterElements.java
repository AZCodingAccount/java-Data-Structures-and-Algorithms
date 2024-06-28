package com.zh.job.monotonicstack;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-28 21:23
 * @description: 下一个更大元素—lc503
 **/
public class NextGreaterElements {
    /*
        下一个更大元素，成环了就遍历两遍就可以了。当然也可以2*nums.length-1，然后按照取模计算即可
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        Arrays.fill(res, -1);
        for (int i = 1; i < nums.length; i++) {
            Integer peeked = stack.peek();
            if (nums[i] > nums[peeked]) {
                while (peeked != null && nums[i] > nums[peeked]) {
                    res[peeked] = nums[i];  // 收集结果
                    stack.pop();
                    peeked = stack.peek();
                }
            }
            stack.push(i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer peeked = stack.peek();
            if (nums[i] > nums[peeked]) {
                while (peeked != null && nums[i] > nums[peeked]) {
                    res[peeked] = nums[i];  // 收集结果
                    stack.pop();
                    peeked = stack.peek();
                }
            }
            stack.push(i);
        }

        return res;
    }
}
