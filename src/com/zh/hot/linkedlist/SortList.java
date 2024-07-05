package com.zh.hot.linkedlist;

import com.zh.algorithm.linkedlist.ListNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-05 15:42
 * @description: 排序链表—lc148
 **/
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        // 统计链表长度
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        // 自下而上归并排序
        for (int i = 1; i < len; i *= 2) { // 每次一堆有几个
            ListNode dummy = new ListNode(-1, null), curr = dummy;  // 新链表
            // 操作几次，向上取整，比如 有5个元素，一次3个，应该分成两堆，操作一次进行排序
            double cnt = Math.ceil(1.0 * len / (i * 2));
            while (cnt-- > 0) {
                ListNode p1 = head, p2 = head, p3;
                // 找到当前组的下一个节点，p2!=null兼容剩下的不足i个
                for (int j = 0; j < i && p2 != null; j++) p2 = p2.next;
                // 记录下一组的起始节点
                p3 = p2;
                for (int j = 0; j < i && p3 != null; j++) p3 = p3.next;
                // 进行两个链表的合并操作
                int l1 = 0, l2 = 0; // 代表本次链表遍历的长度
                while (l1 < i && l2 < i && p1 != null && p2 != null) {
                    if (p1.val <= p2.val) { // 添加第一个链表的节点
                        curr.next = p1;
                        p1 = p1.next;
                        l1++;
                    } else {    // 第二个链表的节点
                        curr.next = p2;
                        p2 = p2.next;
                        l2++;
                    }
                    curr = curr.next;
                }
                // 处理没有合并完的链表   1 2 3  4 5 6
                if (l2 != i) {
                    while (l2 < i && p2 != null) {
                        curr.next = p2;
                        curr = curr.next;   // 移动新链表指针
                        p2 = p2.next;   // 移动老链表指针
                        l2++;
                    }
                }
                if (l1 != i) {
                    while (l1 < i && p1 != null) {
                        curr.next = p1;
                        curr = curr.next;   // 移动新链表指针
                        p1 = p1.next;   // 移动老链表指针
                        l1++;
                    }
                }
                head = p3;  // 更新本轮的下一个节点
            }
            curr.next = null;    // 重新开始防止环
            head = dummy.next;  // 更新head，以后返回出结果
        }
        return head;
    }
}
