package com.zh.hot.linkedlist;

import com.zh.algorithm.linkedlist.ListNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-01 19:44
 * @description: 反转链表2—lc92
 **/
public class ReverseBetween {
    /*
        反转指定区间内的链表，跟K个一组反转链表的处理类似。
        1：将前面一个节点的next指向新链表的头结点
        2：反转区间链表
        3：将前面一个节点的next的next指向处理的后一个节点
        就需要记录这两个节点，免得最后找不着了
     */
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(-1, head);
            ListNode p = dummy;
            // 移动指针，直到指针指向left节点
            for (int i = 0; i < left - 1; i++) {
                p = p.next;
            }
            ListNode rightNode = p.next; // 记录的是刚开始的left节点，结束后指向right的下一个节点
            ListNode pre = p.next;
            ListNode curr = p.next.next;
            // 反转链表
            for (int i = 0; i < right - left; i++) {
                ListNode temp = curr.next;
                curr.next = pre;
                pre = curr;
                curr = temp;
            }
            p.next = pre;
            rightNode.next = curr;
            return dummy.next;
        }
}
