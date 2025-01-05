package com.zh.codetop;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-07 00:24
 * @description: 链表是否有环
 **/
public class HasCycle {
    private class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public boolean hasCycle(ListNode head) {
        // 快慢指针
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
