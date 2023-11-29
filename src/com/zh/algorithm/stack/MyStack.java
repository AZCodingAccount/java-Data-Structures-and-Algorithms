package com.zh.algorithm.stack;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-29 18:39
 * @description: 单个队列实现栈
 **/
public class MyStack {

    /*
     * 使用队列头来模拟栈顶，这样pop和peek就简单了
     * */
    LinkedList<Integer> queue = new LinkedList<>();

    int size = 0;   // 当前队列的长度(栈)

    public MyStack() {

    }

    //  3   4   5   6   1   2
    /* top
     * 入栈的操作是往队列头部插入元素，可以将队列尾部前面的元素都重新入一下队，需要记录一下队列长度
     * */
    public void push(int x) {
        queue.push(x);
        // 把之前的元素重新出队入队
        for (int n = 0; n < size; n++) {
            queue.push(queue.pop());
        }
        size++;
    }

    /*
     * 出栈就是出队
     * */
    public int pop() {
        size--;
        return queue.pop();
    }

    /*
     * 查看类似
     * */
    public int top() {
        return queue.peek();
    }

    /*
     * 判断栈空的条件是size也可以(我们负责维护的)，isEmpty也可以
     * */
    public boolean empty() {
        return queue.isEmpty();
    }
}
