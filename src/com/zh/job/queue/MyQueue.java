package com.zh.job.queue;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-16 20:28
 * @description: 用栈实现队列—lc232
 **/
public class MyQueue {
    LinkedList<Integer> stack1; // 用来入
    LinkedList<Integer> stack2; // 用来出

    public MyQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    /**
     * 首先从stack1把元素压到stack2中，然后再弹出来，压到stack1
     * （这个实现有点蠢，具体来说，就是不拷贝回stack1了，stack2没有元素弹的时候再新增元素，这样弹出来的元素还是FIFO的）
     **/
    public int pop() {
        if (stack2.isEmpty()) {
            // 弹栈并压栈
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /**
     * 直接遍历到最后
     * （与上面的删除同理）
     **/
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty()&&stack2.isEmpty();
    }
}
