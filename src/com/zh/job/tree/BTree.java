package com.zh.job.tree;

import java.util.*;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-17 20:21
 * @description: 二叉树遍历
 **/
public class BTree {

    // Definition for a binary tree node.
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

    /**
     * 前序遍历
     **/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    /**
     * 递归方法
     *
     * @param node 二叉树头结点
     * @param res  结果数组
     */
    private void dfs(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);  // 中
        dfs(node.left, res);    // 左
        dfs(node.right, res);    // 右
    }

    /**
     * 后序遍历
     **/
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs2(root, res);
        return res;
    }

    /**
     * 后序遍历递归方法
     **/
    private void dfs2(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        dfs2(node.left, res);
        dfs2(node.right, res);
        res.add(node.val);
    }

    /**
     * 中序遍历
     **/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs3(root, res);
        return res;
    }

    /**
     * 中序遍历递归方法
     **/
    private void dfs3(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        dfs3(node.left, res);
        res.add(node.val);
        dfs3(node.right, res);
    }


    /**
     * 层序遍历
     **/
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();   // 辅助队列
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();     // 记录单层的节点
            List<Integer> layer = new ArrayList<>();
            while (size-- > 0) {
                // 处理当前元素
                TreeNode polled = queue.poll();
                assert polled != null;
                layer.add(polled.val);
                // 把下一层的元素入队
                if (polled.left != null) {
                    queue.offer(polled.left);
                }
                if (polled.right != null) {
                    queue.offer(polled.right);
                }
            }
            res.add(layer); // 这一层节点值加入结果集
        }
        return res;
    }


    /**
     * 中序遍历，迭代方法 前中后
     **/
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                // 移动指针
                curr = curr.left;
            } else {// 可以出栈了
                curr = stack.pop();
                res.add(curr.val);    // 遍历了这个
                // 看看右边还有没有
                curr = curr.right;
            }
        }
        return res;
    }

    /**
     * 前序遍历—非递归，中前后，每个循环处理一个节点，并把自己的右左节点加入到栈中
     **/
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            // 弹出该元素
            TreeNode popped = stack.pop();
            res.add(popped.val);
            // 把右边和左边元素压栈
            if (popped.right != null) {
                stack.push(popped.right);
            }
            if (popped.left != null) {
                stack.push(popped.left);
            }
        }
        return res;
    }


    /**
     * 后序遍历 左右中，从前序遍历改变而来 中左右—>中右左—>左右中，先改变一下压栈的顺序，再翻转一下数组
     **/
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            // 弹出该元素
            TreeNode popped = stack.pop();
            res.add(popped.val);
            // 把左边和右边元素压栈
            if (popped.left != null) {
                stack.push(popped.left);
            }
            if (popped.right != null) {
                stack.push(popped.right);
            }
        }

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, null)));
        System.out.println(new BTree().preorderTraversal(root));
    }
}
