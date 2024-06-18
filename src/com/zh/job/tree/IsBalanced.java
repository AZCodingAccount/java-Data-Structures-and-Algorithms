package com.zh.job.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-18 15:58
 * @description: 是否是平衡二叉树—lc110
 **/
public class IsBalanced {
    /**
     * 判断是否是平衡二叉树，对每个节点的左右子树高度差都进行判断，如果高度差小于1，那么就是平衡的
     * 这个是标准的后序遍历，左右中，中间节点收集数据判断并返回。
     **/
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    /**
     * 一个递归方法，处理节点的左右子树
     *
     * @param node 当前要处理的节点
     * @return 当前节点深度，返回-1代表不是平衡二叉树
     */
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 计算左子树深度
        int leftCount = dfs(node.left);
        if (leftCount == -1) {
            return -1;
        }
        // 计算右子树深度
        int rightCount = dfs(node.right);
        if (rightCount == -1) {
            return -1;
        }

        // 判断是否是平衡二叉树
        if (Math.abs(leftCount - rightCount) > 1) { // 不是平衡二叉树
            return -1;
        } else {  // 把当前节点深度返回出去，基本干的最多活的代码
            return Math.max(leftCount, rightCount) + 1;
        }
    }
}
