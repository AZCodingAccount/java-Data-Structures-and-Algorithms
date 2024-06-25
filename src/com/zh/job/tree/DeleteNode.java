package com.zh.job.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-25 09:41
 * @description: 删除二叉搜索树中的节点—lc450
 **/
public class DeleteNode {
    /*
        删除节点，分类讨论即可
     */

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null; // 1：没有匹配到节点
        if (root.val == key) {  // 删除当前节点
            if (root.left == null && root.right == null) {  // 2：左右子树都为空
                return null;
            } else if (root.left != null && root.right == null) {  // 3：右子树为空左子树不为空，
                return root.left;
            } else if (root.left == null) { // 4：左子树为空右子树不为空
                return root.right;
            } else {  // 5：左子树和右子树都不为空
                // 选取右节点作为新的父节点，之前接地啊的左子树放到新节点的最左边（二叉搜索树右边一定比左边大）
                TreeNode curr = root.right;
                // 寻找右节点（新父亲）的最左边
                while (curr.left != null) {
                    curr = curr.left;
                }
                // 把老节点的左子树赋值到新节点中
                curr.left = root.left;
                return root.right;
            }
        }
        if (root.val > key) root.left = deleteNode(root.left, key); // 去左子树删除
        if (root.val < key) root.right = deleteNode(root.right, key);    // 去右子树删除
        return root;
    }
}
