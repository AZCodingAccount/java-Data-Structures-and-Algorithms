package com.zh.codetop;

import com.zh.algorithm.linkedlist.ListNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-10-02 1:05
 * @description:
 **/
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // [一组] —> len/k ;
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }

        ListNode dummy = new ListNode(-1, head), prev = dummy, curr = head;

        ListNode first = dummy, second = head;

        // k个一组反转，3   【1,2】  k=2
        while (len >= k) {
            len -= k;
            // 处理某组节点

            // 反转组内节点
            for (int i = 0; i < k; i++) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // 连接左右链表
            first.next = prev;
            second.next = curr;

            // 特例找出普遍条件
            // 更新两个辅助节点
            first = second;
            second = curr;
        }

        // 反转逻辑
        return dummy.next;
    }
}
