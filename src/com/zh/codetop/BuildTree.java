package com.zh.codetop;

import com.zh.datastructures.tree.binarytree.TreeNode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-12-01 22:42
 * @description:
 **/
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;

        // 拿到当前的节点
        int mid = preorder[0];

        // 找到左边和右边分别有几个元素
        int leftCnt = 0, rightCnt = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == mid) {
                leftCnt = i;
                rightCnt = inorder.length - leftCnt - 1;
                break;
            }
        }

        // 继续遍历
        TreeNode curr = new TreeNode(mid);
        curr.left = buildTree(Arrays.copyOfRange(preorder, 1, leftCnt + 1),
                Arrays.copyOfRange(inorder, 0, leftCnt));
        curr.right = buildTree(Arrays.copyOfRange(preorder, leftCnt + 1, preorder.length),
                Arrays.copyOfRange(inorder, leftCnt + 1, inorder.length));

        return curr;
    }
}
