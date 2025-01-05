package com.zh.codetop;

import com.zh.algorithm.linkedlist.ListNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-23 00:45
 * @description:
 **/
public class SortList {
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    private ListNode sort(ListNode head, ListNode tail) {
        if (head == tail) {
            return head;
        }
        // 分治和
        ListNode slow = new ListNode(-1,head), fast = slow;
        while (fast != tail || fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;

        ListNode list1 = sort(head, mid);
        ListNode list2 = sort(mid.next, tail);
        return merge(list1, list2);
    }

    // 合并两个有序链表
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(-1, null);
        while (list1 != null || list2 != null) {
            int val1 = list1 != null ? list1.val : Integer.MAX_VALUE;
            int val2 = list2 != null ? list2.val : Integer.MAX_VALUE;
            if (val1 > val2) {
                res.next = list2;
                list2 = list2.next;
            } else {
                res.next = list1;
                list1 = list1.next;
            }
            res = res.next;
        }
        return res;
    }
}
