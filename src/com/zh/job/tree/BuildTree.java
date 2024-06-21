package com.zh.job.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

import java.util.*;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-21 15:40
 * @description: 从中序和后续遍历序列构造二叉树—lc106
 **/
public class BuildTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
                前/后序+中序都可以构造二叉树，注意顺序。一次递归构建二叉树的一个节点
            但是频繁拷贝会降低性能。
        因此建议新开一个函数，构建一个哈希表，这样查找中间节点是O（1），重构一下代码，传递的都是索引区切割而不是新数组，我这里就不搞了
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {  // 遍历到叶子节点的子节点了，判断左边和判断右边都无所谓
            return null;
        }
        // 从后序序列中取出中间节点
        int middle = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(middle, null, null);
        if (inorder.length == 1) {
            return root;
        }
        // 拿着中间节点去切中序的左右序列
        int middleIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == middle) {
                middleIndex = i;
                break;
            }
        }
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, middleIndex);
        int[] rightInorder = Arrays.copyOfRange(inorder, middleIndex + 1, inorder.length);


        // 找到后序序列的两个子序列，因为遍历序列长度是相等的，前面已经找到了左子树有几个序列，从刚开始截就可以了
        int rightIndex = middleIndex;

        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, rightIndex);
        int[] rightPostorder = Arrays.copyOfRange(postorder, rightIndex, postorder.length - 1);

        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);

        return root;
    }

    public static void main(String[] args) {
        System.out.println(new BuildTree().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}));
    }
}
