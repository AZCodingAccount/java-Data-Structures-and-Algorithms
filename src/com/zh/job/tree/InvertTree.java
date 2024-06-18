package com.zh.job.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-18 10:10
 * @description: 翻转二叉树—lc226
 **/
public class InvertTree {

    /**
     * 前中后序遍历，需要注意的是回溯到哪个节点，后序遍历相对好理解一点。层序遍历也可以，相当于前序遍历
     **/
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);  // 左
        invertTree(root.right);  // 右
        // 中，交换这个节点的左右节点
        if (root.left != null || root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }
}
