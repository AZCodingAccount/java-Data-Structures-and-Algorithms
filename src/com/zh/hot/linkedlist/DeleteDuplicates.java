package com.zh.hot.linkedlist;

import com.zh.algorithm.linkedlist.ListNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-04 12:36
 * @description: 删除链表中的重复元素—lc82
 **/
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy, next = head;  // pre负责更改指针指向，next负责寻找下一个没有重复的元素
        while (next != null && next.next != null) {
            if (next != null && next.next != null && next.val == next.next.val) {
                while (next.val == next.next.val) {
                    next = next.next; // 移动next指针
                }
                pre.next = next.next;   // 删除这些重复元素
                // 移动指针
                next = pre.next;
            } else {  // 正常移动
                pre = next;
                next = next.next;
            }
        }
        return dummy.next;
    }

}
