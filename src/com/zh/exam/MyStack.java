package com.zh.exam;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-29 12:54
 * @description: 单链表实现一个栈
 **/
public class MyStack {

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    ListNode dummy = new ListNode(-1, null);    // 指向链表尾部
    int size = 0;

    public MyStack() {

    }

    // 压栈
    public void push(int e) {
        // todo: 根据业务校验参数
        // 头插法
        ListNode node = new ListNode(e, null);
        node.next = dummy.next;
        dummy.next = node;
        size++; // 维护链表长度
    }

    // 出栈
    public int pop() {
        if (size <= 0) {
            throw new NoSuchElementException("链表为空");
        }
        int deletedNum = dummy.next.val;
        // 删除链表头部元素
        dummy.next = dummy.next.next;
        size--;
        return deletedNum;
    }

    // 查看栈顶元素
    public int peek() {
        if (size <= 0) {
            throw new NoSuchElementException("链表为空");
        }
        return dummy.next.val;
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 获取栈的高度
    public int size(){
        return size;
    }
}
