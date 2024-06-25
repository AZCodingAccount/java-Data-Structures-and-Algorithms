package com.zh.job.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-25 10:11
 * @description: 修剪二叉搜索树—lc669
 **/
public class TrimBST {
    /*
        就是分类讨论，小于low、low-high，大于high三种情况。需要注意的是直接在当前节点删除当前节点和其子树。不需要手动删除指定节点
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) return trimBST(root.right, low, high);   // 删除当前节点和其左子树
        else if (root.val > high) return trimBST(root.left, low, high);   // 删除当前节点和其右子树
        else {  // 哪个都不删除，继续检查左右字数
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }

        return root;

    }
}
