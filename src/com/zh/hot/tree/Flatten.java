package com.zh.hot.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-08 18:49
 * @description: 二叉树展开为链表
 **/
public class Flatten {
    /*
        原地修改
     */
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                // 寻找左子树的最右节点
                TreeNode tempRight = curr.left;
                while (tempRight.right != null) {
                    tempRight = tempRight.right;
                }
                tempRight.right = curr.right;   // 更新指向
                curr.right = curr.left;
            }
            curr = curr.right;  // 此时curr还指向之前的节点，不用移动多个指针，打平后直接进行下一轮会自动向右移
        }
    }
}
