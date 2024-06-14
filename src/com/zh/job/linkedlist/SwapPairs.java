package com.zh.job.linkedlist;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-13 08:42
 * @description: 交换链表的节点—lc24
 **/
/*class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}*/
public class SwapPairs {

    /*
     * 定义两个指针，移动这两个节点
     *
     * */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1, head); // 头结点
        ListNode curr = dummy; // 当前指针

        while (curr.next != null && curr.next.next != null) {
            ListNode temp = curr.next;
            ListNode temp1 = curr.next.next.next;   // 一定记录一下，因为中间2—>1时候断了
            curr.next = curr.next.next; // 更改头结点指向
            curr.next.next = temp;  // 2——>1
            temp.next = temp1;    // 1——>3
            curr = temp;
        }

        return dummy.next;
    }


}




