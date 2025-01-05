package com.zh.codetop;

import com.zh.datastructures.tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-20 00:46
 * @description:
 **/
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode popped = stack.pop();
            res.add(popped.val);
            if (popped.right != null) {
                stack.push(popped.right);
            }
            if (popped.left != null) {
                stack.push(popped.left);
            }
        }
        return res;
    }
}
