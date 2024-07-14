package com.zh.weeklymatch.c406;

import com.zh.algorithm.linkedlist.ListNode;

import java.util.HashSet;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-14 11:06
 * @description: 移除数组中存在节点—406周赛第二题
 **/
public class ModifiedList {
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy, p = dummy.next;
        while (p != null) {
            if (set.contains(p.val)) {
                pre.next = p.next;
                p = p.next;
            } else {  // 更新指针
                pre = p;
                p = p.next;
            }
        }
        return dummy.next;
    }
}
