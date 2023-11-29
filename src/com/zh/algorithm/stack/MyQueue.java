package com.zh.algorithm.stack;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-29 16:48
 * @description: 使用两个栈实现FIFO的队列，leetcode232题
 **/
public class MyQueue {

    LinkedList<Integer> s1 = new LinkedList<>();
    LinkedList<Integer> s2 = new LinkedList<>();

    public MyQueue() {

    }

    /*
     * 实现队列的入队，就是往尾部添加元素，假设s2,代表尾部，push即可
     * */
    public void push(int x) {
        s2.push(x);
    }

    /*
     * 队列元素的出队，假设s1代表头部，需要先把s2里面的元素都弹出来放到s1里面，就实现翻转了  * */
    public int pop() {
        // 仅当s1为空的时候才拷贝s2的元素不需考虑s2中间加的元素，因为是后入队的，得先把前入队的给peek|pop完
        if (s1.isEmpty()) {
            // s2->s1
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        return s1.pop();
    }

    /*
     * 查看第一个元素
     * */
    public int peek() {
        // 仅当s1为空的时候才拷贝s2的元素不需考虑s2中间加的元素，因为是后入队的，得先把前入队的给peek|pop完
        if (s1.isEmpty()) {
            // s2->s1
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        return s1.peek();
    }

    public boolean empty() {
        return s2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int param_3 = obj.peek();
        int param_2 = obj.pop();
        boolean param_4 = obj.empty();
        System.out.println(param_2 + " " + param_3 + " " + param_4);
    }
}
