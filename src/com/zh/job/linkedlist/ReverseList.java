package com.zh.job.linkedlist;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-04-12 21:32
 * @description: 反转链表——lc206
 **/
public class ReverseList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
     /*   ListNode n = null;
        ListNode p = head;
        while (p != null) {
            // 头插法
            n = new ListNode(p.val, n);
            p = p.next;
        }
        return n;*/
        if (head == null) {
            return null;
        }
        // 不使用头插法 1——>2——>3——>4——>5
        //
        ListNode prev = null;
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;     // next=2
            p.next = prev;              // prev=0
            prev = p;                   // prev=1
            p = next;                   // 处理完1以后 p=2
        }
        return prev;
    }
}
