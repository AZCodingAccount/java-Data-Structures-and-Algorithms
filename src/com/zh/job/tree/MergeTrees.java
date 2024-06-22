package com.zh.job.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-22 19:15
 * @description: 合并二叉树—lc617
 **/
public class MergeTrees {
    /*
        合并二叉树，思路很简单，每次处理一个节点，模拟就行
     */

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        // 取出新节点的值
        int val = root1.val + root2.val;
        TreeNode root = new TreeNode(val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }
}
