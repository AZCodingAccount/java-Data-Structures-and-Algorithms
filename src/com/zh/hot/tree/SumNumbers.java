package com.zh.hot.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-12 12:47
 * @description: 求根节点到叶子节点数字之和
 **/
public class SumNumbers {
    int res = 0;

    public int sumNumbers(TreeNode root) {
        preOrder(root, "");
        return res;
    }

    private void preOrder(TreeNode node, String num) {
        if (node == null) {
            res += Integer.parseInt(num);
            return;
        }

        preOrder(node.left, num + node.val);
        preOrder(node.right, num + node.val);
    }
}
