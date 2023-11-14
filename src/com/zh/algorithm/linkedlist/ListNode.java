package com.zh.algorithm.linkedlist;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-14 13:30
 * @description: 链表节点类
 **/
public class ListNode {
    public int val;
    public ListNode next;

    // 定义一个构造方法
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode() {

    }

    // 重写toString方法
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("[");
        ListNode p = this;
        // 遍历链表
        while (p != null) {
            if (p != this) {
                sb.append(",");
            }
            sb.append(p.val);
            p = p.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
