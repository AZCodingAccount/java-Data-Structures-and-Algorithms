package com.zh.hot.linkedlist;

import java.util.HashMap;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-10 10:46
 * @description: 随机链表的复制—lc138
 **/
public class CopyRandomList {

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /*
        本题的关键是使用哈希表建立原节点与新节点映射，这样遍历时候就知道next和random指针所在的链表位置了，且可以在O(1)的时间复杂度
     */
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        // 一次遍历记录节点
        for (Node p = head; p != null; p = p.next) {
            Node node = new Node(p.val);
            map.put(p, node);
        }
        // 一次遍历修正指针
        for (Node p = head; p != null; p = p.next) {
            Node node = map.get(p);
            node.next = map.get(p.next);
            node.random = map.get(p.random);
        }
        return map.get(head);
    }
}
