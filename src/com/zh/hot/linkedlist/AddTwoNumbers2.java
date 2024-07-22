package com.zh.hot.linkedlist;

import com.zh.algorithm.linkedlist.ListNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-22 20:18
 * @description: 两数相加2—lc445
 **/
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 反转链表
        ListNode l3 = reverseList(l1), l4 = reverseList(l2);
        // 两数相加
        int carry = 0;
        ListNode res = new ListNode(-1, null), p = res;
        while (l3 != null || l4 != null) {
            int num1 = l3 == null ? 0 : l3.val;
            int num2 = l4 == null ? 0 : l4.val;
            int num = num1 + num2 + carry;
            if (num >= 10) {
                num %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            p.next = new ListNode(num, null);
            if (l3 != null) l3 = l3.next;
            if (l4 != null) l4 = l4.next;
            p = p.next;
        }
        if (carry == 1) p.next = new ListNode(1, null);
        reverseList(res.next);
        return res.next;
    }

    private ListNode reverseList(ListNode curr) {
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
