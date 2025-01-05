package com.zh.exam;

import com.zh.algorithm.linkedlist.ListNode;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> minStack = new LinkedList<>();

    public Solution() {

    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        Integer element = stack.pop();
        if (minStack.isEmpty() && element == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(-2);
        solution.push(0);
        solution.push(-3);
        System.out.println(solution.getMin());
        solution.pop();
        System.out.println(solution.top());
        System.out.println(solution.getMin());
    }


}