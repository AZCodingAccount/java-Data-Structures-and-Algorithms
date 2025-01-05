package com.zh.codetop;

import com.zh.algorithm.linkedlist.ListNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-12-09 00:15
 * @description:
 **/
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeSort(lists,0,lists.length-1);
    }
    public ListNode mergeSort(ListNode[] lists,int left,int right){
        if(left==right) return lists[left];
        int mid=left+(right-left)>>1;
        ListNode list1=mergeSort(lists,left,mid);
        ListNode list2=mergeSort(lists,mid,right);
        return merge(list1,list2);
    }
    public ListNode merge(ListNode list1,ListNode list2){
        ListNode dummy=new ListNode(-1,null),p=dummy;
        while(list1!=null&&list2!=null){
            if(list1.val>list2.val){
                p.next=list2;
                list2=list2.next;
            }else{
                p.next=list1;
                list1=list1.next;
            }
            p=p.next;
        }
        if(list1!=null) p.next=list1;
        if(list2!=null) p.next=list2;
        return dummy.next;
    }
}
