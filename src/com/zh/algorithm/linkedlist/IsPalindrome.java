package com.zh.algorithm.linkedlist;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-22 18:28
 * @description: 回文链表—leetcode237题
 **/
public class IsPalindrome {

    /*
     * 两种解法，一种是直接翻转，然后遍历比较。这种比较简单
     *   还有一种是先找到链表中点，然后进行翻转。
     * */
    public static ListNode deepCopy(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(head.val, null);
        ListNode currentOriginal = head.next;   // 待拷贝的链表
        ListNode currentNew = newHead;  // 记录一下当前的指向，
        while (currentOriginal != null) {
            currentNew.next = new ListNode(currentOriginal.val, null);
            currentOriginal = currentOriginal.next;
            currentNew = currentNew.next;// 拷贝完成的链表
        }
        return newHead;
    }

    public boolean isPalindrome(ListNode head) {
        // ListNode head1 = deepCopy(head);
        // ListNode newHead = solution1(head);
        // return judgeEqual(head1, newHead);
        ListNode newHead = solution2(head);
        return judgeEqual(head, newHead);   // 这里不用拷贝了，因为改变了也问题不大，反正我们比较的是前面的。

    }


    // 这个方法是第一种简单的解法
    public static ListNode solution1(ListNode o1) {
        return reverseList(o1);
    }

    private static ListNode reverseList(ListNode o1) {
        ListNode p;
        p = o1;
        // o1.next是为递归服务的，o1是为异常服务的
        if (p == null || p.next == null) {
            return p;
        }
        // 递归进行翻转
        // 2 3 4 5 6
        ListNode o2 = solution1(p.next);
        // 让后面的节点指向前面的节点(假如是4，,将5的next指向4而不是6，具体是因为o1.next找到节点，o1.next.next改变指向)
        p.next.next = p;
        p.next = null;
        // 把最原始的节点返回虎丘
        return o2;
    }

    private static boolean judgeEqual(ListNode head1, ListNode newHead) {
        // 比较这两个链表是否相等
        boolean flag = true;
        while (head1 != null && newHead != null) {
            if (head1.val != newHead.val) {
                flag = false;
                break;
            }
            head1 = head1.next;
            newHead = newHead.next;
        }
        return flag;
    }


    /*
    第二种解法是找到中间节点，然后对中间节点的后面这个链表进行翻转，最后循环比较
     */
    public static ListNode solution2(ListNode o1) {
        ListNode middleNode = findMiddleNode(o1);
        return reverseList(middleNode);

    }

    public static ListNode findMiddleNode(ListNode head) {
        // 快慢指针法
        ListNode p1;
        ListNode p2;
        p1 = head;
        p2 = head;
        // 1 2 3 4
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }


    public static void main(String[] args) {
        ListNode list1 = ListNode.of(1, 1, 0, 0, 1);
        ListNode list2 = ListNode.of(1, 2, 1);
        System.out.println(new IsPalindrome().isPalindrome(list1));
        System.out.println(new IsPalindrome().isPalindrome(list2));
    }
}
