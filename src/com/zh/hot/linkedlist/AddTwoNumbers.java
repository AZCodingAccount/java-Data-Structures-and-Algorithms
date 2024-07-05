package com.zh.hot.linkedlist;

import com.zh.algorithm.linkedlist.ListNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-05 19:20
 * @description: 两数相加—lc2
 **/
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1, null), curr = dummy;
        int carry = 0;  // 进位标识
        while (l1 != null || l2 != null) {
            int m = l1 == null ? 0 : l1.val;
            int n = l2 == null ? 0 : l2.val;
            int sum = m + n + carry;  // 总和
            // 修正后的sum
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            curr.next = new ListNode(sum, null);
            // 移动指针
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) curr.next = new ListNode(1, null);
        return dummy.next;
    }
}
