package com.zh.datastructures.stack;

import java.util.Iterator;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-29 14:11
 * @description: 基于链表实现的栈
 **/
public class LinkedListStack<E> implements Stack<E>,Iterable<E>{
    private ListNode<E> head=new ListNode<>(null,null);    // 栈指针
    private int capactiy;  // 栈容量

    private int size;   // 栈当前长度

    public LinkedListStack(int capactiy) {
        this.capactiy = capactiy;
    }

    /*
    * 首先创建一个内部类代表链表节点类
    * */
    static class ListNode<E>{
       public E value;    // 节点值
        public ListNode<E> next;   // 下一个节点的指针

        public ListNode(E value, ListNode<E> next) {
            this.value = value;
            this.next = next;
        }
    }


    /*
    * 入栈
    * */
    @Override
    public boolean push(E value) {
        if(isFull()){
            return false;
        }
        head.next=new ListNode<>(value,head.next);  // 将新入栈的元素指向之前栈顶的元素、并将头指针指向新入栈的元素
        size++;
        return true;
    }

    /*
    * 元素出栈
    * */
    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        ListNode<E> first=head.next;    // 记录一下当前栈顶的元素
        head.next=first.next;   // 改变哨兵节点的指向，指向下一个节点
        size--;  // 更新一下栈的当前长度
        return first.value;
    }

    /*
    * 查看栈顶元素
    * */
    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isFull() {
        return size==capactiy;
    }

    /*
    * 迭代器
    * */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            ListNode<E> p=head;    // 迭代器开始的位置

            // 1 2 3 4 5
            @Override
            public boolean hasNext() {
                return p.next!=null;
            }

            @Override
            public E next() {
                ListNode<E> node=p.next;    // 记录指针
                p=p.next;   // 更新指针
                return node.value;
            }
        };
    }
}
