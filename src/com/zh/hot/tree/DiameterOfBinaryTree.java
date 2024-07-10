package com.zh.hot.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-10 11:13
 * @description: 二叉树的直径—lc543
 **/
public class DiameterOfBinaryTree {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    /*
        求以当前节点为起始节点的最大高度
     */
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        // 求左右子树
        int lCount = dfs(root.left);
        int rCount = dfs(root.right);
        res = Math.max(lCount + rCount + 1, res);    // 更新二叉树直径
        return Math.max(lCount, rCount) + 1;    // 返回最大高度
    }
}
