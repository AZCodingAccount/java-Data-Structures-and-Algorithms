package com.zh.hot.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-19 18:12
 * @description: 子结构判断—lcr143
 **/
public class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return isContain(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isContain(TreeNode a, TreeNode b) {
        if (b == null) return true; // 跳过了之前的检查
        if (a == null) return false;    // a为空，b不为空，那肯定不满足
        if (a.val != b.val) return false;
        return isContain(a.left, b.left) && isContain(a.right, b.right);    // 左和右都要满足
    }
}
