package com.zh.datastructures.Queue;

import java.util.Arrays;
import java.util.Map;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-24 08:41
 * @description: 使用环形数组实现队列
 **/
public class ArrayQueue<E> implements Queue<E> {

    // 头尾指针
    private int head;
    private int tail;

    private final E[] arr;
    private static int originCapacity = 10;

    /*
     * 初始化数组长度
     * */
    public ArrayQueue(int capacity) {
        originCapacity = capacity;
        // 首先找到第一个比他小的第一个2^n的n
        int n = (int) (Math.log10(capacity - 1) / Math.log10(2)) + 1;
        int newCapacity = 1 << n;
        arr = (E[]) new Object[newCapacity];
    }


    /*
     * 队列添加元素
     * */
    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        // 给当前tail指针的数组元素赋值
        arr[tail & arr.length - 1] = value; // 将tail和数组长度-1(数组长度必须为2^n，就不必每次求余维护tail的索引)
        tail++;
        return true;
    }

    /*
     * 队列头部元素查看
     * */
    @Override
    public E pool() {
        if (isEmpty()) {
            return null;
        }
        // 更新head指针的值
        head++;
        return arr[head & arr.length - 1];
    }

    /*
     * 队列头部元素出队
     * */
    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return arr[head];
    }

    @Override
    public boolean isEmpty() {
        return (head & arr.length - 1) == (tail & arr.length - 1);
    }

    @Override
    public boolean isFull() {
        return tail - head == originCapacity;
        // 或者可以 tail-head=arr.length。我这里为了保证传进来的容量和实际容量看起来相同，就直接这么整，看起来有点蠢
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "head=" + head +
                ", tail=" + tail +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }
}
