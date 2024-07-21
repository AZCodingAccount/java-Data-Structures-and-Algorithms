package com.zh.hot.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-21 19:14
 * @description: 是否是子树—lc572
 **/
public class IsSubtree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return false;
        return isContain(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // 判断以当前为根的树包不包含指定子树
    private boolean isContain(TreeNode root, TreeNode subRoot) {
        if (subRoot == null && root == null) return true;
        if (root == null||subRoot==null) return false;
        if (subRoot.val != root.val) return false;
        return isContain(root.left, subRoot.left) && isContain(root.right, subRoot.right);
    }
}
