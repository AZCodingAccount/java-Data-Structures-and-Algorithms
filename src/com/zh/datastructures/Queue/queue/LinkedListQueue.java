package com.zh.datastructures.Queue.queue;

import java.util.Iterator;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-23 21:53
 * @description: 使用链表实现队列
 **/
public class LinkedListQueue<E> implements Queue<E>, Iterable<E> {

    // 指定队列的容量
    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
    }

    public LinkedListQueue() {
    }

    /*
     * 定义一个链表节点
     * */
    public static class ListNode<E> {
        private E value;
        private ListNode<E> next;

        public ListNode(E value, ListNode<E> next) {
            this.value = value;
            this.next = next;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public ListNode<E> getNext() {
            return next;
        }

        public void setNext(ListNode<E> next) {
            this.next = next;
        }
    }

    /*
     * 定义一个带哨兵的链表。一个head一个tail用于实现队列的功能
     * */
    ListNode<E> head = new ListNode<>(null, null);
    ListNode<E> tail = head;

    private int capacity = Integer.MAX_VALUE; // 默认容量为最大
    private int size = 0;     // 代表链表的长度


    /*
     * 实现队列的入队操作
     * */
    @Override
    public boolean offer(E value) {
        if (size >= capacity) {
            return false;
        }
        // 创建一个新节点指向head（尾部节点始终指向head）
        ListNode<E> newNode = new ListNode<>(value, head);
        // 更新tail
        tail.next = newNode;      // 让原来的节点指向newNode
        tail = newNode;           // 更新tail指针
        size++;
        return true;
    }

    @Override
    public E pool() {
        // 说明当前队列没有元素，返回null
        if (size == 0) {
            return null;
        }
        // 更新head的指向(由于哨兵节点是head，tail.next始终指向head，不需考虑tail)
        ListNode<E> first = head.next;    // 获取链表的第一个节点
        head.next = first.next;    // 更新head的指向
        size--;
        return first.value;
    }

    @Override
    public E peek() {
        if (size == 0) {
            return null;
        }
        // 更新head的指向(由于有哨兵节点，因此tail.next始终指向head)
        ListNode<E> first = head.next;    // 获取链表的第一个节点
        return first.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            ListNode<E> p = head.next;  // 注意起始应该是head.next，第一个节点

            @Override
            public boolean hasNext() {
                return p != head;
            }

            @Override
            public E next() {
                E val = p.value;
                p = p.next;
                return val;
            }
        };
    }
}


