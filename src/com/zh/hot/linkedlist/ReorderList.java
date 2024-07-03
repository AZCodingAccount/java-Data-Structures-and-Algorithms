package com.zh.hot.linkedlist;

import com.zh.algorithm.linkedlist.ListNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-03 18:08
 * @description: 重排链表
 **/
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) return;
        // 找到链表中点
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 反转右侧链表
        ListNode pre = null, curr = slow;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        if (prev != null) prev.next = null;   // 断开链表

        // 直接双指针遍历
        ListNode p1 = head, p2 = pre, p = new ListNode(-1, null);
        while (p1 != p2 && p1 != null && p2 != null) {
            // 加入第一个节点
            p.next = p1;
            p = p.next;
            p1 = p1.next;
            // 加入第二个节点
            p.next = p2;
            p = p.next;
            p2 = p2.next;
        }
        // if (p2 != null) p.next = p2;    // 奇数节点情况下右边多一个节点，实际上不用处理，本来就连着呢
    }
}
