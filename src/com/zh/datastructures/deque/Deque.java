package com.zh.datastructures.deque;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-29 19:32
 * @description: 双端队列接口
 **/
public interface Deque<E> {

    // 往队列头部插入
    boolean offerFirst(E e);

    // 往队列尾部插入
    boolean offerLast(E e);

    // 删除队列头部元素
    E pollFirst();

    // 删除队列尾部元素
    E pollLast();

    // 查看队列头部元素
    E peekFirst();

    // 查看队列尾部元素
    E peekLast();

    // 判断队列为空
    boolean isEmpty();

    // 判断队列为满
    boolean isFull();
}
