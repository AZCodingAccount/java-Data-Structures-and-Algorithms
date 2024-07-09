package com.zh.hot.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-09 15:56
 * @description: 从前序和中序序列建树—lc105
 **/
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        // 取出本次的中间节点
        int mid = preorder[0];

        // 根据中间节点找到切分中序序列那个点
        int splitIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == mid) {
                splitIndex = i;
                break;
            }
        }

        TreeNode node = new TreeNode(mid);  // 此时splitIndex就代表切分的长度，由于更改的是原数组，因此不需要考虑索引相加情况
        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, splitIndex + 1);
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, splitIndex);
        int[] rightPreOrder = Arrays.copyOfRange(preorder, splitIndex + 1,preorder.length);
        int[] rightInOrder = Arrays.copyOfRange(inorder, splitIndex + 1,inorder.length);
        node.left = buildTree(leftPreOrder, leftInOrder);
        node.right = buildTree(rightPreOrder, rightInOrder);
        return node;
    }
}
