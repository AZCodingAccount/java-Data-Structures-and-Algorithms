package com.zh.hot.linkedlist;

import com.zh.algorithm.linkedlist.ListNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-14 14:25
 * @description: 删除排序链表中的重复元素2—lc83
 **/
public class DeleteDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head, curr = head.next;
        while (curr != null) {
            if (pre.val == curr.val) {
                pre.next = curr.next;   // 跳过当前节点
            } else {
                pre = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}
