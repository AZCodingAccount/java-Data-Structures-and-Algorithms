package com.zh.hot.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

public class Codec {

    // Encodes a tree to a single string.
    // 1,2,null,null,3,4,null,null,5,null,null,
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) { // 处理子树为空的情况
                sb.append("null,");
                continue;
            }
            sb.append(node.val).append(",");
            // 不管是不是空都放进去
            stack.push(node.right);
            stack.push(node.left);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] nodes = data.split(",");
        LinkedList<String> deque = new LinkedList<>();
        for (String node : nodes) {
            deque.offer(node);
        }
        TreeNode root = new TreeNode(Integer.parseInt(deque.poll()));
        root.left = helper(deque);
        root.right = helper(deque);
        return root;
    }

    private TreeNode helper(LinkedList<String> deque) { // deque一定不为空
        String val = deque.poll();
        if (val.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = helper(deque);
        node.right = helper(deque);
        return node;
    }

    public static void main(String[] args) {
        System.out.println(new Codec().serialize(new TreeNode(new TreeNode(null, 2, null), 1, null)));
    }
}