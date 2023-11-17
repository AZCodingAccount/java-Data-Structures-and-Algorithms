package com.zh.algorithm.linkedlist;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-17 18:34
 * @description: 删除重复的节点——力扣83题
 **/
public class DeleteDuplicateNode {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        // 这个元素往后遍历，直到他的next为空即可
        while (p1.next != null) {
            if (p1.val == p1.next.val) {
                // 删除p1.next这个节点，让p1,指向p1.next.next
                p1.next = p1.next.next;
            } else {
                // 往后平移一位
                p1 = p1.next;
            }
        }
        return head;
    }

    /*
    * 递归解法，
    * */
    public static ListNode deleteDuplicates2(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        if (p.val == p.next.val) {
            return deleteDuplicates(p.next);
        } else {
            p.next = deleteDuplicates(p.next);
            // 更新p.next的原因为在递归过程中,p.next对应的节点可能会被删除。因此需要更新成他下一个节点不去重的
            // 把当前链表赋值成后面已经去重的链表，这样就不会导致p指针异常了
            return p;
        }
    }


    public static void main(String[] args) {
        ListNode head = com.zh.algorithm.linkedlist.ListNode.of(1, 1, 2, 2, 3);
        System.out.println(head);
        ListNode newHead = deleteDuplicates(head);
        System.out.println(newHead);
    }
}
