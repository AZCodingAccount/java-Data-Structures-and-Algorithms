package com.zh.hot.linkedlist;

import com.zh.algorithm.linkedlist.ListNode;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-09 17:53
 * @description: 回文链表
 **/
public class IsPalindrome {
    /*
        一次遍历求出中点，中点之前入栈，然后依次弹出
     */
    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        int cnt = 0;
        while (p != null) {
            p = p.next;
            cnt++;
        }
        LinkedList<ListNode> stack = new LinkedList<>();    // 存放中点之前的链表
        p = head;
        for (int i = 0; i < cnt / 2; i++) {
            stack.push(p);
            p = p.next;
        }
        if (cnt % 2 != 0) p = p.next;   // 奇数往前走一格
        for (int i = 0; i < cnt / 2; i++) {
            ListNode popped = stack.pop();
            if (popped.val != p.val) return false;
            p = p.next;
        }
        return true;
    }
}
