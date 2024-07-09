package com.zh.hot.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-09 18:05
 * @description: 路径总和3—lc437
 **/
public class PathSum {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return (pathSumFrom(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum));
    }

    private int pathSumFrom(TreeNode node, long targetSum) {
        if (node == null) return 0;
        int count = (node.val == targetSum ? 1 : 0);
        count += pathSumFrom(node.left, targetSum - node.val);
        count += pathSumFrom(node.right, targetSum - node.val);
        return count;
    }

}
