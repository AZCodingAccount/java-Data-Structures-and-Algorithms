package com.zh.codetop;

import com.zh.algorithm.linkedlist.ListNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-13 00:46
 * @description: 合并两个有序链表—lc21
 **/
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(-1, null), p = res;
        while (list1 != null && list2 != null) {
            ListNode node = null;
            if (list1.val > list2.val) {
                node = new ListNode(list2.val, null);
                list2 = list2.next;
            } else {
                node = new ListNode(list1.val, null);
                list1 = list1.next;
            }
            p.next = node;
            p = p.next;
        }
        // list1为null
        if (list1 == null) p.next = list2;
        if (list2 == null) p.next = list1;
        return res.next;
    }
}
