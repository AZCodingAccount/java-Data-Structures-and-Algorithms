package com.zh.hot.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-10 17:45
 * @description: 二叉搜索树中第K小的元素—lc230
 **/
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                if (--k == 0) return curr.val;
                curr = curr.right;
            }
        }
        return -1;
    }
}
