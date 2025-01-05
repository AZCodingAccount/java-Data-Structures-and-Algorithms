package com.zh.codetop;

import java.util.LinkedList;
import java.util.Stack;

class MyQueue {

    LinkedList<Integer> stack1 = new LinkedList<>();
    LinkedList<Integer> stack2 = new LinkedList<>();

    public MyQueue() {

    }

    public void push(int x) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack2.push(x);
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public int pop() {
        return stack2.pop();
    }

    public int peek() {
        return stack2.peek();
    }

    public boolean empty() {
        return stack2.isEmpty();
    }
}
