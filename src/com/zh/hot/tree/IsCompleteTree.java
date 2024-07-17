package com.zh.hot.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-17 18:02
 * @description: 二叉树的完整性检验—lc958
 **/
public class IsCompleteTree {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return false;
        LinkedList<TreeNode> queue = new LinkedList<>();
        int layer = 0;  // 代表当前第几层
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size(), len = 0;
            boolean flag = false;   // 代表左侧是否出现了空孩子
            while (size-- > 0) {
                TreeNode node = queue.poll();
                // 有任意一个左右孩子并且前面为空
                if ((node.left != null || node.right != null) && flag) return false;
                // 后面不许有左右孩子
                if (node.left == null || node.right == null) flag = true;
                if (node.right != null && flag) return false;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsCompleteTree().isCompleteTree(new TreeNode(
                new TreeNode(new TreeNode(null, 4, null), 2, new TreeNode(null, 5, null)),
                1,
                new TreeNode(new TreeNode(null, 6, null), 3, null)
        )));
    }
}
