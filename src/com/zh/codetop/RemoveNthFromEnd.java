package com.zh.codetop;

import com.zh.algorithm.linkedlist.ListNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-19 00:49
 * @description:
 **/
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head), slow = dummy, fast = dummy;
        // fast移动
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 一起移动，直到fast.next为null
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // 删除节点
        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        return dummy.next;
    }
}
