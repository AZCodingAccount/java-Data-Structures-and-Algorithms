package com.zh.codetop;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-18 00:37
 * @description:
 **/
public class MaxPathSum {
    int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return sum;
    }

    /**
     * 计算以当前节点一侧的高度
     *
     * @param root
     * @return
     */
    private int maxSum(TreeNode root) {
        if (root == null) return 0;
        int leftSum = Math.max(maxPathSum(root.left),0);
        int rightSum =Math.max( maxPathSum(root.right),0);
        sum = Math.max(root.val + leftSum + rightSum, sum); // 记录下当前结果
        return root.val + Math.max(leftSum, rightSum);
    }
}
