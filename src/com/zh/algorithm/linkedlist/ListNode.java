package com.zh.algorithm.linkedlist;

import com.zh.datastructures.main.SingleLinkedList;

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

    // 快速构造链表元素，头插法
    /* public static ListNode of(int... args) {
        ListNode head = new ListNode();
        for (int arg : args) {
            head.next = new ListNode(arg, head.next);
        }
        return head.next;
    }*/

    // 快速构造链表元素，尾插法
    public static ListNode of(int... args) {
        ListNode head = new ListNode(); // 哑节点
        ListNode tail = head; // 初始时，尾部指针指向哑节点

        for (int arg : args) {
            tail.next = new ListNode(arg, null); // 在尾部添加新节点
            tail = tail.next; // 更新尾部指针，保证尾部指针始终指向最后一个元素
        }

        return head.next; // 返回不包含哑节点的链表，这个时候head.next指向第一次插入元素的节点（第一次使用tail.next）
    }

    public static ListNode deepCopy(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(head.val, null);
        ListNode currentOriginal = head.next;
        ListNode currentNew = newHead;
        while (currentOriginal != null) {
            currentNew.next = new ListNode(currentOriginal.val, null);
            currentOriginal = currentOriginal.next;
            currentNew = currentNew.next;
        }
        return newHead;
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
