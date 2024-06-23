package com.zh.job.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-23 19:27
 * @description: 二叉树的最近公共祖先—lc236
 **/
public class LowestCommonAncestor {
    /*
           后序遍历，左右中，只有左右子树都不为空时返回当前当前节点，否则返回其中一个不为空的节点
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) { // 当前节点一定没有匹配的节点
            return null;
        }
        if (root == p || root == q) {   // 找到了匹配的节点
            return root;
        }
        TreeNode leftAncestor = lowestCommonAncestor(root.left, p, q);
        TreeNode rightAncestor = lowestCommonAncestor(root.right, p, q);

        // 处理匹配成功的逻辑
        if (leftAncestor != null && rightAncestor != null) {
            return root;
        }
        // 左孩子不为空
        if (leftAncestor != null) {
            return leftAncestor;
        }
        return rightAncestor;   // 返回右孩子（因为左孩子一定为空了）
    }
}
