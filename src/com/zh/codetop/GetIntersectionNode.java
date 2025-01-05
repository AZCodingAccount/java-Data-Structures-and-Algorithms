package com.zh.codetop;

import com.zh.algorithm.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-17 22:40
 * @description: 相交链表—lc160
 **/
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode p1 = headA, p2 = headB;
        while (p1 != null) {
            set.add(p1);
            p1 = p1.next;
        }
        // 第一个重复的节点就是结果
        while (p2 != null) {
            if (set.contains(p2)) {
                return p2;
            }
            set.add(p2);
            p2 = p2.next;
        }
        return null;
    }
}
