package com.zh.job.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-18 10:46
 * @description: 对称二叉树—lc101
 **/
public class IsSymmetric {

    /**
     * 判断对称二叉树，定义一个递归方法，搜索左子树和右子树即可。体现的是一个后序遍历思想，遍历完了收集并向上返回
     **/
    public boolean isSymmetric(TreeNode root) {
        return rec(root.left, root.right);
    }

    //          2
    //     3       3
    // 4   5     null  4

    /**
     * 递归方法，前面的if应该算是剪枝
     **/
    private boolean rec(TreeNode left, TreeNode right) {
        // 成功的退出条件
        if (left == null && right == null) {
            return true;
        }
        // 失败的退出条件
        if ((left != null && right == null) || (left == null) || (left.val != right.val)) {
            return false;
        }
        // 接下来比较子节点并收集
        boolean leftBool = rec(left.left, right.right); // 左
        boolean rightBool = rec(left.right, right.left);    // 右
        return leftBool && rightBool;   // 中
    }
}
