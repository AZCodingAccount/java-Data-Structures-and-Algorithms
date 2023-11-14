package com.zh.algorithm.linkedlist;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-14 16:43
 * @description: 删除指定的链表节点 leetcode LCR 021。采用递归和两个指针两种方法实现
 **/
public class DeleteCertainNode {

    /*
     * 使用递归实现，返回值为整数，
     * */
    public static int recursive(ListNode node, int n) {
        if (node == null) {
            return 0;
        }
        // 找到下一个节点的倒数位置
        int nth = recursive(node.next, n);
        // 找到倒数第n个了，没有考虑第一个节点，再加一个哨兵
        // 一个元素的时候也会出现问题
        if (nth == n) {
            node.next = node.next.next;
        }
        return nth + 1;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode s = new ListNode(-1, head);
        recursive(s, n);
        return s.next;  // 注意这里返回的是s.next，head的指向在循环中并没有更新
    }

    /*
     下面给出一个全新的解法，主要是基于两个指针来实现的，首先初始化两个指针都指向哨兵节点。然后将p2指针往右移动n+1个节点的位置
     接着开始遍历链表，直到p2指针指向的位置为空，这个时候p1指针指向的位置就是要删除元素的前一个节点。直接删除即可。
     这种实现方法要优于遍历以后再遍历一次（这个问题最直观的实现）。这个有很明显的面向过程的特征
    (删除链表一般都使用两个指针，如果使用指针实现的话。因为链表删除节点的时候需要修改前一节点的指向，但是前一节点不好直接选择到)
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        // 创建哨兵节点
        ListNode s = new ListNode(-1, head);
        // 初始化两个指针
        ListNode p1 = s;
        ListNode p2 = s;
        // 移动第二个指针
        for (int i = 0; i < n + 1; i++) {
            p2 = p2.next;
        }
        // 开始遍历链表
        while (p2 != null) {
            // 更新状态
            p1 = p1.next;
            p2 = p2.next;
        }
        // 找到节点直接删除
        p1.next = p1.next.next;

        return s.next;
    }

    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(4, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o5);
        // 删除节点
        ListNode new_list = removeNthFromEnd2(o1, 5);
        System.out.println(new_list);
    }
}
