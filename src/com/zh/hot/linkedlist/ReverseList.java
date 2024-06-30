package com.zh.hot.linkedlist;

import com.zh.algorithm.linkedlist.ListNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-30 18:30
 * @description: 反转链表—lc206
 **/
public class ReverseList {
    /*
        迭代和递归
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        return reverseNode(head, null);
    }

    private ListNode reverseNode(ListNode curr, ListNode prev) {
        if (curr == null) return prev;
        ListNode temp = curr.next;
        curr.next = prev;
        return reverseNode(temp, curr);
    }
}
