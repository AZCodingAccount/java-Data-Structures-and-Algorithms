package com.zh.hot.linkedlist;

import com.zh.algorithm.linkedlist.ListNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-18 19:00
 * @description: 奇偶链表—lc328
 **/
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode curr = head, even = head.next;
        int cnt = 0;
        while (curr.next.next != null) {
            ListNode next = curr.next;
            // 将当前节点指向当前节点的下一个节点的下一个节点
            curr.next = curr.next.next;
            curr = next;
            cnt++;
        }
        if(cnt%2!=0){
            curr.next.next = even;  // 连接两个链表
            curr.next = null;       // 断开之前的连接
        }else{
            curr.next=even;
            curr.next.next=null;
        }
        return head;
    }
}
