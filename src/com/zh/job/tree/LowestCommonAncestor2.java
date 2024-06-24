package com.zh.job.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-24 21:24
 * @description: 二叉搜索树的最近公共祖先—lc235
 **/
public class LowestCommonAncestor2 {
    /*
        利用一下二叉搜索树的特性，使用中序遍历搜索，可能有以下几种情况
        1：当前节点的值在p和q中间，说明当前节点就是它两的最近公共祖先。这是很显然的
        2：当前节点值大于p和q，说明搜索右子树
        3：当前节点值小于p和q，说明搜索左子树
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if ((root.val > p.val) && (root.val > q.val)) {  // 在左子树里面
            return lowestCommonAncestor(root.left, p, q);
        }

        if ((root.val < p.val) && (root.val < q.val)) { // 在右子树里面
            return lowestCommonAncestor(root.left, p, q);
        }
        // 当前这个节点在它两中间，返回当前节点
        return root;
    }
}
