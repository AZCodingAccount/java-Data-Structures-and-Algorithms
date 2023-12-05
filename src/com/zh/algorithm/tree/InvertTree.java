package com.zh.algorithm.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-12-05 21:06
 * @description: 翻转二叉树—leetcode226题
 **/
public class InvertTree {

    /*
     * 这个是从上到下一次交换。注意引用和副本的区别
     * */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
