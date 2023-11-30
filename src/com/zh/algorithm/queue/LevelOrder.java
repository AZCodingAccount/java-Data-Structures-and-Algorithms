package com.zh.algorithm.queue;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-30 20:45
 * @description: 二叉树层序遍历，使用队列实现—leetcode102题
 **/
@SuppressWarnings("all")
public class LevelOrder {

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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 1 2 3 4 5
        //   1
        //  2 3
        // 3 4 5
        ArrayList<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();   // 存储二叉树节点的队列
        int length = 1;   // 初始化结点数长度
        queue.offer(root);
        while (!queue.isEmpty()) {
            int length2 = 0;  // 记录下一层的结点数
            ArrayList<Integer> layerNodes = new ArrayList<>();// 记录这一层的节点
            // 一个for循环遍历一层
            for (int n = 0; n < length; n++) {
                // 出队，遍历他的节点
                TreeNode node = queue.poll();
                layerNodes.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                    length2++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    length2++;
                }
            }
            length = length2;
            res.add(layerNodes);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LevelOrder().levelOrder(new TreeNode(1,
                new TreeNode(3, null, null),
                new TreeNode(4, null, null))));
    }

}
