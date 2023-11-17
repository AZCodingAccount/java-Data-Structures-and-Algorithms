package com.zh.algorithm.linkedlist;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-17 19:27
 * @description: 删除链表中重复的所有节点—leetcode82题
 **/
public class DeleteDuplicateAllNode {
    public static ListNode deleteDuplicatesAllNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode track = new ListNode(-1, head); // 哑结点
        ListNode p1 = track; // p1 指向哑结点

        // 这里使用的是单节点，可能会有点容易错，可以使用双指针或三指针的思路
        /*
         * 三指针，p1,p2,p3。p1类似于哨兵节点，主要用于删除元素(初始化为哨兵)。p2，p3作为两个元素比较的指针
         * p2.val==p3.val时，这个时候p3向后移动，直到找到第一个跟之前元素不等的值。
         * 找到元素后，将p1.next指向p3即可，中间的所有元素就删除调了，我这个边遍历边删除也是可以的
         * */
        while (p1.next != null && p1.next.next != null) {
            if (p1.next.val == p1.next.next.val) {
                int duplicateVal = p1.next.val;
                // 这样之前的那两个相等的也会进来走删除的逻辑
                while (p1.next != null && p1.next.val == duplicateVal) {
                    // 跳过所有重复的节点
                    p1.next = p1.next.next;
                }
            } else {
                // 如果当前节点不是重复的，只需移动p1
                p1 = p1.next;
            }
        }
        return track.next; // 返回不包含哑结点的链表
    }

    /*
     * 递归方法实现
     * */
    public static ListNode deleteDuplicatesAllNode2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            // 递归的找下面相等的元素
            ListNode p2 = head.next.next;
            while (p2 != null && p2.val == head.val) {
                p2 = p2.next;
            }
            // 找到第一个未重复的元素，指针为p2，把p2传进去即可。递归的找下一组未重复链表
            return deleteDuplicatesAllNode2(p2);
        } else {
            head.next = deleteDuplicatesAllNode2(head.next);  // 返回的永远是当前的最优结果
            // 更新p.next的原因为在递归过程中,p.next对应的节点可能会被删除。因此需要更新成他下一个节点不去重的
            // 把当前链表赋值成后面已经去重的链表，这样就不会导致p指针异常了
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode head = com.zh.algorithm.linkedlist.ListNode.of(1, 1, 2, 2, 3);
        System.out.println(head);
        ListNode newHead = deleteDuplicatesAllNode2(head);
        System.out.println(newHead);
    }
}
