package com.zh.hot.linkedlist;

import com.zh.algorithm.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-03 10:12
 * @description: 合并K个升序链表—lc23
 **/
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        ListNode dummy = new ListNode(-1, null), p = dummy;
        for (ListNode list : lists) {
            heap.offer(list);
        }
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            p.next = node;
            if (node.next != null) heap.offer(node.next);
            p = p.next;
        }
        return dummy.next;
    }
}
