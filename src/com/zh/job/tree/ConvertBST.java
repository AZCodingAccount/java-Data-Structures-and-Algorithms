package com.zh.job.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-29 13:02
 * @description: 把二叉搜索树转换成累加树—lc538
 **/
public class ConvertBST {
    /*
        只要是二叉搜索树，一般都要用到中序遍历是从小到大的顺序，题目中要求将节点的值转换成大于等于它的节点的和。
    可以维护一个sum，按照右中左的顺序遍历，然后遍历到该节点就更新该节点的val和sum值
     */
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        root.right = convertBST(root.right); // 转换右子树
        root.left = convertBST(root.left);  // 转换左子树
        // 处理中间节点
        sum += root.val;
        root.val = sum;
        return root;
    }
}
