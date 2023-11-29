package com.zh.datastructures.stack;

import java.util.Iterator;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-29 14:48
 * @description: 数组实现栈
 **/
public class ArrayStack<E> implements Stack<E>, Iterable<E> {


    private int top = 0; // 栈顶指针

    private E[] arr;

    public ArrayStack(int capactiy) {
        this.arr = (E[]) new Object[capactiy];
    }

    /*
     * 入栈，给数组赋值改变栈顶指针
     * */
    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        arr[top++] = value;
        return true;
    }

    /*
     * 出栈，取到数组top元素并更新top值
     * */
    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        return arr[--top];
    }

    /*
     * 查看栈顶元素
     * */
    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return arr[top - 1];
    }

    /*
     * 判断栈是否为空，看top指针是不是为0
     * */
    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    /*
     * 判断栈是不是为满，看top指针是不是等于capacity
     * */
    @Override
    public boolean isFull() {
        return top == arr.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = top;  // 初始化指针

            @Override
            public boolean hasNext() {
                return p > 0;   // 是大于0，因为top是数组索引+1
            }

            @Override
            public E next() {
                return arr[--p];
            }
        };
    }
}
