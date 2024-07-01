package com.zh.hot.linkedlist;

import com.zh.algorithm.linkedlist.ListNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-01 20:18
 * @description: K个一组反转链表—lc25
 **/
public class ReverseKGroup {
    /*
        把反转指定区间的代码拿过来改改就行，每次反转完更新一下leftNode，连接一下链表
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        // 求长度
        ListNode p1 = head;
        while (p1 != null) {
            len++;
            p1 = p1.next;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode leftNode = dummy;  // 左节点
        ListNode pre = null;    // 反转链表的前指针
        ListNode curr = dummy.next; // 反转链表的当前指针
        while (len >= k) {
            // 反转链表（curr从第一个节点开始是必须的，虽然第一个节点没啥用，但是也不用循环以后更新了，也不用关心空指针问题）
            // 如果从1开始，那么当k=1的时候，在1—>2—>3—>4—>5，最后一个节点时，会出现NPE的错误，因为curr=curr.next时没有判空
            for (int i = 0; i < k; i++) {
                ListNode temp = curr.next;
                curr.next = pre;
                pre = curr;
                curr = temp;
            }

            ListNode start = leftNode.next; // 存下来下一个前一个节点

            // 连接链表
            leftNode.next = pre;    // 连接头节点
            start.next = curr;      // 连接尾节点

            leftNode = start;       // 更新前一个节点，pre和curr不用更新，就是正常的值
            len -= k;
        }

        // 不足k个也要反转
        pre = null; // 一定要置为空，不然成环了
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        leftNode.next = pre;    // 连接头节点
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n5 = new ListNode(5, null);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        System.out.println(new ReverseKGroup().reverseKGroup(n1, 3));
    }
}
