package com.zh.algorithm.linkedlist;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-14 15:54
 * @description: leetcode203题，根据值删除链表节点，递归和两个指针两种方法实现
 **/
public class DeleteNode {
    /*
     * 删除链表节点，o代表链表头结点，val代表要删除的元素值
     * 第一种思路：定义两个指针，p1,p2。p1指向遍历节点的前一节点，p2指向当前遍历节点，再定义一个哨兵处理第一个节点的特殊情况
     * */
    public static ListNode deleteNode(ListNode o, int val) {
        // 定义哨兵节点
        ListNode s = new ListNode(-1, o);
        // 定义两个指针，这里p2放到里面赋值可能好一点，这里简化了，对象之间是可以引用的，因此我改变p2，o也会改变，s也会改变
        ListNode p1 = s;
        ListNode p2 = o;
        // 开始循环遍历，遍历结束条件为p2为null了结束遍历
        while (p2 != null) {
            // 如果当前节点的值跟指定的val相等
            if (p2.val == val) {
                // 把这个节点删除，p2往后移动一次
                p1.next = p2.next;
                p2 = p2.next;
            } else {
                // p1和p2都往右边移动一次
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        // 把更新完毕的节点返回回去
        return s.next;
    }

    /*
     * 递归实现：每次递归都判断当前节点值和目标值是否相同，相同执行删除逻辑，不同则不处理
     * 返回的是一个节点，表示他之后的节点状态
     * */
    public static ListNode deleteNodeByRecursive(ListNode o, int val) {
        // 结束条件，所有节点遍历完成
        if (o == null) {
            return o;
        }
        // 进行递归
        if (o.val == val) {
            // 相等就跳过该节点，这个节点不再考虑了
            return deleteNodeByRecursive(o.next, val);
        } else {
            // 更新一下当前节点之后的节点状态。
            o.next = deleteNodeByRecursive(o.next, val);
            return o;
        }
    }

    public static void main(String[] args) {
        ListNode o5 = new ListNode(4, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(4, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);
        // 删除节点
        ListNode new_list = deleteNodeByRecursive(o1, 4);
        System.out.println(new_list);

        // 这个是初始化问题，实际上函数可以处理这种情况
        // ListNode o6 = new ListNode();
        // System.out.println(o6);
        // ListNode listNode = deleteNode(o6, 6);
        // System.out.println(listNode);

    }

}
