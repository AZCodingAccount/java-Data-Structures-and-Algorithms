package com.zh.algorithm.linkedlist;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-19 21:42
 * @description: 查找中间节点，力扣876题-simple
 **/
public class FindMiddleNode {

    /*
     * 快慢指针法，快指针一次两步，慢指针一次走两步。类似的查找三分之一，四分之一也是这个思路
     * */
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        // 当p2指向null或者p2.next指向null时（奇偶情况），p1指向了中间节点
        while (p2 != null && p2.next != null) { // 写到里面是或者，写到while里面是并且
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode list1 = ListNode.of(1, 2, 3, 4, 5);
        ListNode middleNode = new FindMiddleNode().middleNode(list1);
        System.out.println(middleNode);
    }


}
