package com.zh.codetop;

import com.zh.datastructures.tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-20 00:32
 * @description:
 **/
public class InorderTraversal {
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return res;
        // dfs(root);
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {  // 回溯，收集结果
                TreeNode popped = stack.pop();
                res.add(popped.val);
                curr = popped.right;
            }
        }

        return res;
    }

    // private void dfs(TreeNode node) {
    //     if (node == null) return;
    //     res.add(node.val);// 中
    //     dfs(node.left);     // 左
    //     dfs(node.right);    // 右
    // }
}
