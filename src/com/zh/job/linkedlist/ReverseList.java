package com.zh.job.linkedlist;

import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-04-12 21:32
 * @description: 反转链表——lc206
 **/
public class ReverseList {
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

    public ListNode reverseList(ListNode head) {
     /*   ListNode n = null;
        ListNode p = head;
        while (p != null) {
            // 头插法
            n = new ListNode(p.val, n);
            p = p.next;
        }
        return n;*/
        if (head == null) {
            return null;
        }
        // 不使用头插法 1——>2——>3——>4——>5
        //
        ListNode prev = null;
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;     // next=2
            p.next = prev;              // prev=0
            prev = p;                   // prev=1
            p = next;                   // 处理完1以后 p=2
        }
        return prev;
    }


    // 递归解法，每次递归处理一个元素
    public ListNode reverseListByRec(ListNode head) {
        return reverseNode(head, null);
    }

    // null  1—>     2——>        3
    //              curr
    //      prev
    //      temp

    /**
     * @param curr 当前要反转的节点
     * @param prev 要反转的前一个节点
     * @return com.zh.job.linkedlist.ReverseList.ListNode   新的头结点
     * @description 翻转某个节点
     **/
    private ListNode reverseNode(ListNode curr, ListNode prev) {
        // 退出条件是curr=null，说明最后一个节点也处理完了（curr.next=null是处理最后一个节点）
        if (curr == null) {
            return prev;
        }
        // 翻转当前节点
        ListNode temp = curr.next;
        curr.next = prev;
        prev = curr;   // 移动上一个节点
        // curr = temp.next;   // 这里为什么会出现问题？？？temp会跟着curr变，注意引用问题！！！~！
        curr = temp;
        return reverseNode(curr, prev);
    }
}
