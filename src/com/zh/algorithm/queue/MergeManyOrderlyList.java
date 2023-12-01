package com.zh.algorithm.queue;

import com.zh.algorithm.linkedlist.ListNode;

import java.util.PriorityQueue;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-12-01 17:18
 * @description: 合并多个有序链表—优先级队列实现
 **/
public class MergeManyOrderlyList {

    // 实现的思路是小顶堆里面的元素代表链表的值，由几个链表小顶堆里面就有几个元素，第一次遍历把链表的三个指针加入到小顶堆中。
    // 再从从小顶堆出去的那个链表节点的next加进去（这样才可以进行遍历），直到小顶堆的元素被遍历完了为止。（就代表三个链表遍历完成了）
    // 这种需要遍历，时间复杂度是很糟的
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode result = new ListNode();
        ListNode s = result;  // 这个是用于循环的

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        // 首先初始化小顶堆
        for (int n = 0; n < lists.length; n++) {
            if (lists[n] != null) {
                minHeap.offer(lists[n]);
            }
        }
        while (!minHeap.isEmpty()) {
            // 首先拿出一个最小的节点
            ListNode min = minHeap.poll();
            s.next = min; // 连上去
            s = min;  // 更新一下结果的链表
            // 往小顶堆加入元素(出堆的下一个节点)
            if (min.next != null) {
                minHeap.offer(min.next);
            }
        }
        return result.next;

    }

    public static void main(String[] args) {
        ListNode list1 = ListNode.of(1, 2, 2, 3);
        ListNode list2 = ListNode.of(1, 2, 2, 3);
        ListNode list3 = ListNode.of(4, 5);
        ListNode list4 = ListNode.of(3, 8);
        ListNode[] lists = new ListNode[]{list1, list2, list3, list4};
        ListNode list = mergeKLists(lists);
        System.out.println(list);
    }
}
