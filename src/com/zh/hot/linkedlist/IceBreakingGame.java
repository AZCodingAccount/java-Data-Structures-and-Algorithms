package com.zh.hot.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-24 18:41
 * @description: lcr187—破冰游戏
 **/
public class IceBreakingGame {

    /*
        约瑟夫环，模拟+数学
     */
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 链表模拟，pass
    public int iceBreakingGame2(int num, int target) {
        ListNode head = new ListNode(0, null), p = head;
        // 构造链表
        for (int i = 1; i < num; i++) {
            p.next = new ListNode(i, null);
            p = p.next;
        }
        p.next = head;    // 串成循环链表
        // dummy.next = null;
        // 开始模拟     prev   curr
        ListNode prev = p, curr = head;
        // 0    1   2   3   4   5   6
        // 0    1   2   4   5   6
        // 1    2   4   5   6
        // 1    2   4   6
        // 1    2   (6)
        // 1    (2)
        // 1
        while (curr.next != curr) {
            // prev = curr;
            // 找到要删除的节点`
            for (int i = 1; i < target % num; i++) {
                prev = curr;
                curr = curr.next;
            }
            // 删除该节点
            prev.next = curr.next;
            curr = curr.next;   // 更新最新的curr
        }
        return curr.val;
    }

    // 数组模拟
    public int iceBreakingGame3(int num, int target) {
        if (num == 1) return 0;
        List<Integer> list = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            list.add(i);
        }
        // 模拟移除过程，不用遍历，但有复制的开销
        int begin = 0;
        while (list.size() > 1) {
            int idx = (begin + target - 1) % (list.size());
            list.remove(idx);
            begin = idx;
        }
        return list.get(0);
    }

    // 数学解法
    public int iceBreakingGame(int num, int target) {
        if (num == 1) return 0;
        int res = 0;
        for (int i = 2; i <= num; i++) {
            res = (res + target) % i;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new IceBreakingGame().iceBreakingGame(7, 4));
        System.out.println(new IceBreakingGame().iceBreakingGame(12, 5));
        System.out.println(new IceBreakingGame().iceBreakingGame(5, 1));
    }
}
