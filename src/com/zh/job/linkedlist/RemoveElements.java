package com.zh.job.linkedlist;

import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-08 21:53
 * @description: 移除链表元素—lc203
 **/
public class RemoveElements {
    // Definition for singly-linked list.
    public static class ListNode {
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

    // 3—>2—>1
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null) {
            // 当前节点的下一个节点需要删除了
            if (p.next.val == val) {
                p.next = p.next.next; // 当前节点指向当前节点的下一个节点的下一个节点
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2, p1);
        ListNode p3 = new ListNode(3, p2);

        ListNode node = new RemoveElements().removeElements(p3, 2);
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print("->");
            }
            node = node.next;
        }
    }
}
