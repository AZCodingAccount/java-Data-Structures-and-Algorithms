package com.zh.job.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-18 15:19
 * @description: 完全二叉树的节点个数—lc222
 **/
public class CountNodes {
    /**
     * 计算完全二叉树的节点个数，可以判断其子树是否是满二叉树，这样根据2^k-1可以快速计算出节点个数（k为深度），
     * 从左边遍历到底和右边遍历到底高度是否相等。注意完全二叉树的性质，不然普通二叉树不能这样判断慢二叉树
     **/
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 判断该节点是否是满二叉树
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        int lDepth = 1;
        int rDepth = 1;

        while (leftNode != null) {
            lDepth++;
            leftNode = leftNode.left;
        }
        while (rightNode != null) {
            rDepth++;
            rightNode = rightNode.right;
        }
        if (lDepth == rDepth) {
            return (int) (Math.pow(2, lDepth) - 1);
        }
        // 说明当前子树不是完全二叉树，向下搜索
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return leftCount + rightCount + 1;  // 返回所有节点数量
    }

    public static void main(String[] args) {
        System.out.println(new CountNodes().countNodes(new TreeNode(
                new TreeNode(new TreeNode(null, 4, null), 2, new TreeNode(null, 5, null)),// 左
                1,  // 值
                new TreeNode(new TreeNode(null, 6, null), 3, null)  // 右
        )));
    }
}
