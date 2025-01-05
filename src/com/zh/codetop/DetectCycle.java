package com.zh.codetop;

import com.zh.algorithm.linkedlist.ListNode;

import java.util.HashSet;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-07 00:30
 * @description: 检测环
 **/
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (set.contains(p)) {
                return p;
            }
            set.add(p);
            p = p.next;
        }
        return null;
    }
}
