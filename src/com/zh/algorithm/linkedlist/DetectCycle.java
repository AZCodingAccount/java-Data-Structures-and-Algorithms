package com.zh.algorithm.linkedlist;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-22 20:57
 * @description: 检测环的入口
 **/
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        // 快慢指针，Floyd龟兔算法
        ListNode p1 = head;
        ListNode p2 = head;

        while (p1 != null && p1.next != null) {
            p1 = p1.next.next;  // 兔子一次走两步
            p2 = p2.next; // 乌龟一次走一步
            if (p1 == p2) {
                // 找到链表
                // 让乌龟回到起点
                p2 = head;
                // 接下来都走一步，如果下一次相遇，就是链表入口
                while (p1 != p2) {
                    p1 = p1.next;   // 兔子一次走一步
                    p2 = p2.next;   // 乌龟一次走一步
                }
                return p2;  // 返回环的入口
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // ListNode head = ListNode.of(1, 2, 3, 4, 8);
        // head.next.next.next.next.next = head.next.next;   // 8这个节点指向3
        // System.out.println(head);
        ListNode n5 = new ListNode(1, null);
        ListNode n4 = new ListNode(3, n5);
        ListNode n3 = new ListNode(5, n4);
        ListNode n2 = new ListNode(6, n3);
        ListNode n1 = new ListNode(1, n2);
        n5.next = n3;
        // 不要直接打印，重写后的toString方法我没加处理循环链表这一段的逻辑
        System.out.println(new DetectCycle().detectCycle(n1).val);
    }
}
