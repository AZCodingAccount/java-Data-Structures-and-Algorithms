package com.zh.algorithm.linkedlist;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-14 13:29
 * @description: 反转链表，leetcode206
 **/
public class ReverseList {
    public static ListNode reverseList(ListNode o1) {
        // 定义一个节点存储返回回去的结果
        ListNode n1 = null;
        ListNode p = o1;
        // 头插法遍历o1链表赋值给n1，尾插法引入尾指针或者遍历搜索n1
        while (p != null) {
            n1 = new ListNode(p.val, n1);
            p = p.next;
        }
        return n1;
    }

    // 优化第一个算法，减少链表的赋值操作（10次-5次）
    public static ListNode reverseList2(ListNode o1) {
        // 初始化两个链表
        List list1 = new List(o1);
        List list2 = new List(null);
        // 这里不能再使用p了，p和o1共用一个内存空间，removeFirst把第一个元素拿出来了，addFirst修改了第一个节点的next值。p和o1也跟着变了
        while (true) {
            // 从原来链表中移除元素
            ListNode first = list1.removeFirst();
            // 判断链表中的元素是不是复制完了
            if (first == null) {
                break;
            }
            // 往新链表添加元素
            list2.addFirst(first);
        }
        return list2.head;
    }

    // 构造一个链表类进行存储
    static class List {
        // 只需要一个头结点就可以了，这个链表，不是结点
        ListNode head;

        public List(ListNode head) {
            this.head = head;
        }

        // 赋值两个方法，一个是往链表的头结点插入节点，针对新链表
        public void addFirst(ListNode firstNode) {
            // 更新原来head的next指针
            firstNode.next = head;
            // 让加入的这个新节点变成头结点
            head = firstNode;
        }

        // 移除链表中的第一个节点，针对原链表
        public ListNode removeFirst() {
            // 把当前的head记录下来等下返回回去
            ListNode removeNode = head;
            // 对题目要求的head为空进行判断
            if (removeNode == null) {
                return null;
            }
            // head的下一个节点变成了新的head
            head = removeNode.next;
            return removeNode;
        }
    }


    // 递归方式反转链表
    public static ListNode reverseList3(ListNode o1) {
        // 结束条件和题目异常值
        if (o1 == null || o1.next == null) {
            return o1;
        }
        // 首先找到后面一个节点
        ListNode lastNode = reverseList3(o1.next);
        // 改变next的指向，让当前节点的下一个节点指向当前节点（5->4,4—>3），让当前节点的下一个节点暂时指向空(避免死循环)
        o1.next.next = o1;
        o1.next = null;
        // 返回尾节点作为头结点进行遍历
        return lastNode;
    }

    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);
        ListNode n1 = reverseList3(o1);
        System.out.println(n1);
    }


}
