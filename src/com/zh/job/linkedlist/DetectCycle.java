package com.zh.job.linkedlist;

import java.util.HashSet;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-14 17:08
 * @description: 检测环和求环的起始节点—lc142
 **/
public class DetectCycle {

    /**
     * 找出环形链表的第一个头结点
     * 1：使用Floyd算法，数学证明第一次相遇必定在环这里
     * 2：使用HashSet，遇到重复的节点就说明找着了
     **/
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            // 链表暂时没有环，只需要判断fast即可
            if (fast == null || fast.next == null) {
                return null;
            }

            // 链表可能有环
            // 移动指针
            slow = slow.next;
            fast = fast.next.next;

            // 找到链表入口
            if (slow == fast) {
                break;
            }
        }
        // 接下来从起点重新开始，一次走一步
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 判断链表是否有环，跟前面那个快慢指针一模一样，找到交接点直接return就可以了。这里使用HashSet
     **/
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        HashSet<ListNode> set = new HashSet<>();
        ListNode curr = head;
        while (true) {
            if (curr.next == null) {    // next==null就说明没环了
                break;
            }
            if (set.contains(curr)) {  // 发现有相同的了
                return true;
            } else {  // 正常遍历
                set.add(curr);
                curr = curr.next;
            }
        }
        return false;
    }
}
