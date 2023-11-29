package com.zh.datastructures.stack;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-29 14:12
 * @description: 栈的接口
 * **/
public interface Stack<E> {

    /*
    * 入栈方法
    * */
    boolean push(E value);

    /*
    * 弹出元素
    * */
    E pop();

    /*
    * 查看栈顶元素
    * */
    E peek();

    /*
    * 判断栈是否为空
    * */
    boolean isEmpty();

    /*
    * 判断栈是否为慢
    * */
    boolean isFull();


}
