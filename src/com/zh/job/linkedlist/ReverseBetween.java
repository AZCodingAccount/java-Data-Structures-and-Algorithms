package com.zh.job.linkedlist;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-04-16 19:10
 * @description: 反转链表2—lc92
 **/
public class ReverseBetween {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 反转链表
        ListNode sentinel = new ListNode(-1, head);   // 初始化哨兵节点
        ListNode lLeft = sentinel;
        for (int i = 0; i < left - 1; i++) {
            lLeft = lLeft.next;
        }   // 移动目标节点，反转该区间内的链表，此时p0指向2

        ListNode leftNode = lLeft.next;
        ListNode prev = lLeft.next;
        ListNode p0 = prev.next;
        for (int i = 1; i < right - left + 1; i++) {
            // 指向前一个，记录下一个的位置
            ListNode next = p0.next;    // 记录下一个的位置
            p0.next = prev;             // 指向前一个节点
            prev = p0;                  // 更新prev
            p0 = next;                  // 更新下一个节点
        }
        // 左节点
        leftNode.next = p0;
        lLeft.next = prev;
        return sentinel.next;
    }
}
