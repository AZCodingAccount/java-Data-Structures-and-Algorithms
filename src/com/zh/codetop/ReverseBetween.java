package com.zh.codetop;

import com.zh.algorithm.linkedlist.ListNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-14 22:07
 * @description:
 **/
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 找到前一个节点和上上个节点
        ListNode pre = new ListNode(-1, head), p = head;
        for (int i = 0; i < left - 1; i++) {
            p = p.next;
            pre = p;
        }
        ListNode start = pre, end = pre.next;

        // 反转链表
        ListNode prev = p, p1 = p.next;
        for (int i = 0; i < (right - left) + 1; i++) {
            ListNode temp = p1.next;
            p1.next = prev;
            prev = p1;
            p1 = temp;
        }

        // 连接链表
        start.next = prev;
        end.next = p1;

        return head;
    }
}
