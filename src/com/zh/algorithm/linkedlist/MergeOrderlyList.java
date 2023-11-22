package com.zh.algorithm.linkedlist;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-18 22:02
 * @description: 合并有序链表，力扣22题
 **/
public class MergeOrderlyList {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode s = new ListNode(-1, null);
        ListNode p = s;
        // 循环遍历，直到有一个链表为空
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                // 把list2的节点添加进新链表
                p.next = list1;
                // 更新list1的值
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        // 把剩余链表中的元素拷贝过去
        if (list1 != null) {
            p.next = list1;
        }
        if (list2 != null) {
            p.next = list2;
        }
        return s.next;
    }

    /*
    * 递归实现，逻辑是这样的，递归返回一个当前最小的指针。并且需要更新当前这个小的指针的位置，继续往后寻找最小的指针。
    * 当有一个链表遍历完成之后，返回对应链表的指针即可。这样在递归结束后，会返回一个指针，完整的把两个链表串起来了
    * 3 4 5
    * 1 1 2 2
    * */
    public static ListNode mergeTwoLists2(ListNode list1,ListNode list2){
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        if(list1.val>list2.val){
            // 第二个元素小，更新第二个元素的指针，继续去寻找最小的
            list2.next=mergeTwoLists2(list1,list2.next);
            return list2;
        }else{
            // 第一个元素小，更新第一个元素的指针，继续去寻找最小的
            list1.next=mergeTwoLists2(list1.next,list2);
            return list1;
        }
    }
    public static void main(String[] args) {
        ListNode list1 = ListNode.of(1, 2, 2, 3);
        ListNode list2 = ListNode.of(1, 2, 2, 3);
        ListNode list = mergeTwoLists2(list1, list2);
        System.out.println(list);
    }
}
