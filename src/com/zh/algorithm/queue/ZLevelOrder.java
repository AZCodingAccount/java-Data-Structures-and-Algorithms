package com.zh.algorithm.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-30 21:16
 * @description: 二叉树Z层序遍历—双端队列实现—leetcode103题
 **/
public class ZLevelOrder {

    public static class TreeNode {
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

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        // 1 3 2 4 5
        //   1
        //  2 3
        // 4 5 6 7
        // 这里使用双端队列来实现，碰到偶数层的时候使用头部插入元素。改变layerNodes的方法
        ArrayList<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();   // 存储二叉树节点的队列
        int length = 1;   // 初始化结点数长度
        queue.offer(root);
        boolean odd = true; // 当前层是奇还是偶
        while (!queue.isEmpty()) {
            int length2 = 0;  // 记录下一层的结点数
            LinkedList<Integer> layerNodes = new LinkedList<>();// 记录这一层的节点
            // 一个for循环遍历一层
            for (int n = 0; n < length; n++) {
                // 出队，遍历他的节点
                TreeNode node = queue.poll();
                if (odd) {
                    layerNodes.offerLast(node.val);
                } else {
                    layerNodes.offerFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    length2++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    length2++;
                }
            }
            odd = !odd; // 更新当前层数
            length = length2;
            res.add(layerNodes);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(zigzagLevelOrder(new TreeNode(1,
                new TreeNode(3, null, null),
                new TreeNode(4, null, null))));
    }

}
