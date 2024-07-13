package com.zh.hot.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-13 17:16
 * @description: 二叉树最大宽度—lc662
 **/
public class WidthOfBinaryTree {
    /*
        BFS实现
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        LinkedList<Integer> indexQueue = new LinkedList<>();
        int res = 0;
        nodeQueue.offer(root);
        indexQueue.offer(1);
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            int left = indexQueue.peek();
            while (size-- > 0) {
                int index = indexQueue.poll();
                TreeNode node = nodeQueue.poll();
                if (size == 0) {    // 最右边的元素
                    res = Math.max(index - left + 1, res);  // 更新最大宽度
                }
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    indexQueue.offer(2 * index);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    indexQueue.offer(2 * index + 1);
                }
            }
        }
        return res;
    }
}
