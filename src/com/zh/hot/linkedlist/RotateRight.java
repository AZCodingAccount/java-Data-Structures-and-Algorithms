package com.zh.hot.linkedlist;

import com.zh.algorithm.linkedlist.ListNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-18 19:40
 * @description: 旋转链表—lc61
 **/
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        // 1:统计链表长度
        ListNode curr = head;
        int cnt = 0;
        while (curr != null) {
            cnt++;
            curr = curr.next;
        }
        // 2：移动链表指针到后半段长度
        ListNode origin = head;
        k = k % cnt;
        for (int i = 0; i < cnt - k; i++) {
            origin = origin.next;
        }
        // 3：拼接后半段
        ListNode res = new ListNode(-1, null), p = res;
        while (origin != null) {
            p.next = origin;
            p = p.next;
            origin = origin.next;
        }
        // 4：拼接前半段
        origin = head;
        for (int i = 0; i < cnt - k; i++) {
            p.next = origin;
            p = p.next;
            origin = origin.next;
        }
        p.next = null;
        return res.next;
    }
}
