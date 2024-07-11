package com.zh.hot.stack;

import java.util.LinkedList;

class MinStack {
    LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> minStack = new LinkedList<>();
    int min = Integer.MAX_VALUE;  // 当前元素最小值

    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        min = Math.min(val, min);   // 永远存储的都是当前已知元素的最小值
        minStack.push(min);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public int getMin() {
        return minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }
}