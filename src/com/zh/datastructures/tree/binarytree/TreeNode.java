package com.zh.datastructures.tree.binarytree;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-14 19:40
 * @description: 二叉树的节点
 **/
public class TreeNode {
    public int val; // 二叉树节点的值
    public TreeNode left;  // 二叉树左子树
    public TreeNode right;  // 二叉树右子树

    // 定义两个重载的构造函数
    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode( TreeNode left,int val, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
