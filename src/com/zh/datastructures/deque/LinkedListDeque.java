package com.zh.datastructures.deque;

import java.util.Iterator;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-29 19:30
 * @description: 基于双向环形链表实现的双端队列
 **/
public class LinkedListDeque<E> implements Deque<E>, Iterable<E> {

    int capacity;   // 双端队列容量
    int size;       // 双端队列当前长度

    ListNode<E> sentinel = new ListNode<>(null, null, null);

    public LinkedListDeque(int capacity) {
        // 初始化
        this.capacity = capacity;
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    static class ListNode<E> {
        ListNode<E> prev;
        E value;
        ListNode<E> next;

        public ListNode(ListNode<E> prev, E value, ListNode<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    /* s 1 2 3 4
     * 往队列头部添加元素，找到这个元素的prev(s)，这个元素的next(s.next)。最后更新s的指向和s.next的prev指针为新添加的节点
     * */
    @Override
    public boolean offerFirst(E e) {
        if (isFull()) {
            return false;
        }
        ListNode<E> prev = sentinel;
        ListNode<E> next = sentinel.next;
        ListNode<E> node = new ListNode<>(prev, e, next);
        sentinel.next = node;
        next.prev = node;
        size++;
        return true;
    }

    /* s 1 2 3 4
     * 往队列尾部添加元素，找到这个元素的prev(s.prev)，这个元素的next(s)。最后更新s.prev的指向和原来的最后一个元素的next指向(4)
     *                                              （这里也可以进行先sentinel.prev.next=node,再更新sentinel，下面的直观点）
     * */
    @Override
    public boolean offerLast(E e) {
        if (isFull()) {
            return false;
        }
        ListNode<E> prev = sentinel.prev;
        ListNode<E> next = sentinel;
        ListNode<E> node = new ListNode<>(prev, e, next);
        sentinel.prev = node;
        prev.next = node;
        size++;
        return false;
    }

    /* s 1 2 3 4
     * 移除队列头部的元素。找到prev为s,next为s.next.next。更新prev的next为next 和next的prev为sentinel即可。
     *                                                       同样，这里也可以直接操作sentinel
     * */
    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }
        ListNode<E> prev = sentinel;
        E value = prev.next.value;
        ListNode<E> next = sentinel.next.next;
        prev.next = next;       // sentinel.next.next.prev=sentinel
        next.prev = sentinel;   // sentinel.next=sentinel.next.next
        size--;
        return null;
    }

    /* s 1 2 3 4
     * 移除队列尾部的元素。这里直接操作sentinel了。让s.prev.prev.next指向s; s.prev指向s.prev.prev。
     *                                           （顺序不能颠倒，因为第二个式子会改变s.prev的指向）
     * */
    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        ListNode<E> removed = sentinel.prev;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return removed.value;
    }


    /* s 1 2 3 4
     *   取出队列第一个元素。直接取即可
     * */
    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return sentinel.next.value;
    }

    /* s 1 2 3 4
     *   取出队列最后一个元素。直接取即可
     * */
    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return sentinel.prev.value;
    }

    // 判空，看size或者sentinel的prev和next的指向
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // 判满，只能size==capacity
    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            ListNode<E> p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }


}
