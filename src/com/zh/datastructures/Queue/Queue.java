package com.zh.datastructures.Queue;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-23 21:57
 * @description: 队列接口
 **/
public interface Queue<E> {

    // 队列的添加
    boolean offer(E value);

    // 队列的删除
    E pool();

    // 从队列中拿出一个元素但不删除
    E peek();

    // 判断队列是否为空
    boolean isEmpty();

    // 判断队列是否为满
    boolean isFull();
}
