package com.zh.codetop;

import com.zh.algorithm.linkedlist.ListNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-17 23:07
 * @description:
 **/
public class ReorderList {
    public void reorderList(ListNode head) {
        // 寻找中点
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;

        // 反转后半部分链表
        ListNode prev = null, curr = mid.next;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        mid.next = null;
        // 合并两个子链表
        ListNode l1 = head, l2 = prev;
        while (l1 != null && l2 != null) {
            ListNode l1Next = l1.next, l2Next = l2.next;
            l1.next = l2;
            l1 = l1Next;

            l2.next = l1;
            l2 = l2Next;
        }
    }
}
