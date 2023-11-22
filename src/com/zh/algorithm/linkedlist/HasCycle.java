package com.zh.algorithm.linkedlist;

import java.util.HashMap;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-22 20:20
 * @description: 判断环形链表—leetcode141题
 **/
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        // 快慢指针，Floyd龟兔算法
        ListNode p1 = head;
        ListNode p2 = head;

        while (p2 != null && p2.next != null) {
            p1 = p1.next.next;  // 兔子一次走两步
            p2 = p2.next; // 乌龟一次走一步
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2);
        head.next.next = head;
        System.out.println(new HasCycle().hasCycle(head));
    }
}
