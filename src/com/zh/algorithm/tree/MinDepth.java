package com.zh.algorithm.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-12-05 20:46
 * @description: 求二叉树的最小高度—leetcode111题
 **/
public class MinDepth {

    /*
     * 使用递归和层序遍历两种方法解。层序遍历时间复杂度优，递归直观
     * */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        // 注意，这里需要考虑一种特殊情况，当其中一棵子树为null时，这时的minDepth应该是另外一颗树
        if (root.left == null && root.right != null) {
            return right;
        }
        if (root.left != null && root.right == null) {
            return left;
        }
        return Integer.min(left, right) + 1;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int minDepth = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return minDepth + 1;
                }
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
            }
            minDepth += 1;
        }
        return minDepth;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(null, 9, null),
                3,
                new TreeNode(new TreeNode(null, 15, null),
                        20,
                        new TreeNode(null, 7, new TreeNode(null, 10, null)))
        );
        /*      3
         * 9         20
         *       15     7
         *                10
         * */
        System.out.println(new MinDepth().minDepth2(root));
    }
}
