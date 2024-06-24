package com.zh.job.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-24 21:36
 * @description: 二叉搜索树的插入操作—lc701
 **/
public class InsertIntoBST {
    /*
        实际上，插入二叉搜索树的节点，这个节点一定是根节点，所以不会涉及到旋转等反人类的树操作。
        那还挺简单的，前序遍历，找到为空的节点，插入进去就可以了。
     */

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);   // 到低了，可以插进去了
        }

        // 如果当前节点大于目标值
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        // 如果当前节点小于目标值
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
