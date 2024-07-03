package com.zh.hot.linkedlist;

import com.zh.algorithm.linkedlist.ListNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-03 16:55
 * @description: 相交链表
 **/
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        int count1 = 0, count2 = 0;
        while (p1 != null) {
            p1 = p1.next;
            count1++;
        }
        while (p2 != null) {
            p2 = p2.next;
            count2++;
        }
        p1 = headA;
        p2 = headB;
        if (count1 > count2) {
            for (int i = 0; i < count1 - count2; i++) {
                p1 = p1.next;
            }
        } else {
            for (int i = 0; i < count2 - count1; i++) {
                p2 = p2.next;
            }
        }
        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}
