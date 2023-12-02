package com.zh.datastructures.Queue.deque;

import java.util.Iterator;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-30 12:25
 * @description: 基于环形数组实现的双端队列
 **/
public class ArrayDeque<E> implements Deque<E>, Iterable<E> {

    /*
     * 使用环形数组实现，首先head和tail两个指针，但是要考虑的是索引越界的问题（这里不能跟之前的队列那简单的取余或者位运算，因为会出现负数）。
     * 因此定义两个方法来处理两个指针的更新。inc和dec，head的指针指向队列头部元素，tail的指针指向队列尾部元素+1的位置(判满需要)。
     *   （也可以head指向队列头部元素-1，tail指向尾部元素。都可以。但是不可以head指向头，tail指向尾，这样实现起来太麻烦了）
     *  -1    0    1   2   3   4
     * null   a    b   c   d              （数组长度为4，存储元素的位置为0-3，第4个元素的索引是为了给tail的）
     *      head
     *                        tail
     * dec方法，如果i-1小于0，那么就给他赋值为arr.length-1。其他情况，正常-即可
     * inc方法，如果i+1大于arr.length，那么就给他赋值为0。其他情况，正常+即可
     * offerFirst。让head调用dec方法。然后将value赋值给arr[head]
     * offerLast。让首先将value赋值给arr[tail]，然后tail调用inc方法
     * pollFirst。记录一下当前元素的value，并把元素的指向置为null（GC）.head指针往后移一位，就是删除了。
     * pollLast。tail指针往前移一位，就是删除。记录一下当前arr[tail]=value,return，并置null
     * peekFirst。return arr[head]
     * peekLast。return arr[tail-1]
     * isEmpty。看head==tail
     * isFull。看inc(tail)是不是为head
     * */

    int head = 0;
    int tail = 0;

    E[] arr;

    @SuppressWarnings("all")
    public ArrayDeque(int capacity) {
        arr = (E[]) new Object[capacity + 1];
    }


    int dec(int i) {
        if (i - 1 < 0) {
            return arr.length - 1;
        }
        return i - 1;
    }

    int inc(int i) {
        if (i + 1 >= arr.length) {
            return 0;
        }
        return i + 1;
    }

    @Override
    public boolean offerFirst(E e) {
        if (isFull()) {
            return false;
        }
        head = dec(head);
        arr[head] = e;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if (isFull()) { // 上面+到数组元素-1的位置时候就不能再加了
            return false;
        }
        arr[tail] = e;
        tail = inc(tail);
        return true;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }
        E value = arr[head];
        arr[head] = null;
        head = inc(head);
        return value;
    }

    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        tail = dec(tail);
        E value = arr[tail];
        arr[tail] = null;
        return value;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return arr[head];
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return arr[tail - 1];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return head == inc(tail);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E value = arr[p];
                p = inc(p);
                return value;
            }
        };
    }


}
