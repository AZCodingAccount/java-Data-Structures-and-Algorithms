package com.zh.hot.linkedlist;

import com.zh.algorithm.linkedlist.ListNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-02 09:32
 * @description: 合并两个有序链表—lc21
 **/
public class MergeTwoLists {
    /*
        一种是三指针，一种是直接把list2的拷贝到list1上，使用三指针
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1, null), tail = dummy, p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }
        if (p1 == null) tail.next = p2;
        else tail.next = p1;
        return dummy.next;
    }
}
