package com.zh.job.linkedlist;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-14 16:10
 * @description: 删除链表中的倒数第N个节点—lc19
 **/
public class RemoveNthFromEnd {

    /**
     * 使用双指针解法,等到后面这个指针遍历到头了，前面这个指针指向的下一个节点就是需要被移除的节点（这样遍历次数只需要O（n））
     **/
    @SuppressWarnings("all")
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1, head);
        // ListNode
        ListNode prev = dummy;
        ListNode next = dummy.next;
        // 2号指针准备就绪
        while (n-- > 0) {
            next = next.next;
        }
        while (next != null) {
            // 移动双指针
            prev = prev.next;
            next = next.next;
        }
        // 找到节点(因为next至少高于prev两个节点，因此prev一定)
        prev.next = prev.next.next;
        return dummy.next;
    }


}
