package com.zh.hot.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-19 17:48
 * @description: 寻找二叉搜索树中的目标节点—lcr174
 **/
public class FindTargetNode {
    // 右中左
    public int findTargetNode(TreeNode root, int cnt) {
        if (root == null || cnt <= 0) return -1;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr.right);
                curr = curr.right;
            } else {
                TreeNode popped = stack.pop();
                if (--cnt <= 0) return popped.val;
                curr = popped.left;
            }
        }
        return -1;
    }
}
