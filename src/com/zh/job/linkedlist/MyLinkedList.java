package com.zh.job.linkedlist;

import java.util.LinkedList;
import java.util.List;

class MyLinkedList {
    int size;


    private ListNode sentinel;

    public MyLinkedList() {
        this.sentinel = new ListNode(-1, null);
        this.size = 0;
    }

    // 获取元素，只能遍历
    public int get(int index) {
        // 校验
        if (index >= size || index < 0) {
            return -1;
        }
        ListNode curr = sentinel;
        // 找到当前元素
        while (index >= 0) {
            index--;
            curr = curr.next;
        }
        // 返回当前元素
        if (curr != null) {
            return curr.val;
        }
        return -1;
    }

    // 头插法
    public void addAtHead(int val) {
        sentinel.next = new ListNode(val, sentinel.next);
        size++;
    }

    // 尾插法
    public void addAtTail(int val) {
        ListNode curr = sentinel;
        // 找到链表最后一个节点
        while (curr.next != null) {
            curr = curr.next;
        }
        // 找到最后一个节点了
        curr.next = new ListNode(val, null);
        size++;
    }


    // 指定索引添加元素
    public void addAtIndex(int index, int val) {
        // 校验
        if (index > size || index < 0) {
            return;
        }
        ListNode curr = sentinel;
        // 找到当前索引的上一个元素
        while (index - 1 >= 0) {
            index--;
            curr = curr.next;
        }
        // 当前元素的下一个元素指向新增的节点，新增节点指向之前的节点
        curr.next = new ListNode(val, curr.next);
        size++;
    }

    // 指定索引删除元素
    public void deleteAtIndex(int index) {
        // 校验
        if (index >= size || index < 0) {
            return;
        }
        ListNode curr = sentinel;
        // 找到当前索引的上一个元素
        while (index - 1 >= 0) {
            index--;
            curr = curr.next;
        }
        // 当前元素的下一个元素指向当前元素的下一个节点的下一个节点
        curr.next = curr.next.next;
        size--;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
        myLinkedList.get(1);              // 返回 2
        myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
        myLinkedList.get(1);              // 返回 3

    }
}


class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

