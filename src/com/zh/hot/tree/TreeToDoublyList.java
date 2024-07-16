package com.zh.hot.tree;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-16 19:27
 * @description: 将二叉搜索树转化成排序的双向链表—lcr155
 **/
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

public class TreeToDoublyList {


    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        LinkedList<Node> stack = new LinkedList<>();
        Node curr = root;
        LinkedList<Node> nodes = new LinkedList<>();
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                Node node = stack.pop();
                nodes.offer(node);
                curr = node.right;
            }
        }
        // 重新组装
        Node res;
        if (nodes.size() >= 2) {
            // 首先连接首尾部分
            Node first = nodes.peekFirst();
            Node last = nodes.peekLast();
            first.left = last;
            last.right = first;
            res = nodes.poll();
            Node pre = res, p;
            while (!nodes.isEmpty()) {
                p = nodes.poll();
                pre.right = p;
                p.left = pre;
                pre = p;
            }
        } else {  // 只有一个节点
            Node node = nodes.peek();
            res = node;
            node.left = node;
            node.right = node;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new TreeToDoublyList().treeToDoublyList(
                new Node(2, new Node(1, null, null), new Node(3, null, null))));
    }
}
