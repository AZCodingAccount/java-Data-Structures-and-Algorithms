package com.zh.algorithm.linkedlist;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-19 21:20
 * @description: 合并多个有序链表， 力扣23题-hard
 **/
public class MergeManyOrderlyList {
    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val > list2.val) {
            // 第二个元素小，更新第二个元素的指针，继续去寻找最小的
            list2.next = mergeTwoLists2(list1, list2.next);
            return list2;
        } else {
            // 第一个元素小，更新第一个元素的指针，继续去寻找最小的
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        }
    }

    /*
     * 使用归并排序的思想，把数组里面的多个链表进行分，然后到一个时候再合并。
     * */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return splitListsArr(lists, 0, lists.length - 1);
    }

    /*
     * lists代表链表数组，i代表分解的起始索引，j代表结束索引
     * */
    private static ListNode splitListsArr(ListNode[] lists, int i, int j) {
        // 说明只有一个元素了，就可以返回回去着手合并了。
        if (i >= j) {
            return lists[i];
        }
        // 将链表进行分解
        int m = (i + j) >>> 1;
        ListNode leftLists = splitListsArr(lists, i, m);
        ListNode rightLists = splitListsArr(lists, m + 1, j);
        // 开始合并，他们始终是两个链表，从下到上，是肯定可以合并出来结果的
        return mergeTwoLists2(leftLists, rightLists);
    }

    public static void main(String[] args) {
        ListNode list1 = ListNode.of(1, 2, 2, 3);
        ListNode list2 = ListNode.of(1, 2, 2, 3);
        ListNode list3 = ListNode.of(4, 5);
        ListNode list4 = ListNode.of(3, 8);
        ListNode[] lists = new ListNode[]{list1,list2,list3,list4};
        ListNode list = mergeKLists(lists);
        System.out.println(list);
    }
}
