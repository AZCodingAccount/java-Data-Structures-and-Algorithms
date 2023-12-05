package com.zh.algorithm.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-12-05 19:32
 * @description: 求二叉树最大深度—leetcode104，使用递归、非递归的后序遍历、层序遍历三种方法
 **/
public class MaxDepth {
    /*
     * 递归的思路是首先遍历左边的子树，记录他们的最大深度，再遍历右边的子树。跟左边的比较，取一个最大的
     * */
    public int maxDepth(TreeNode root) {
        // 节点为null说明深度为0
        if (root == null) {
            return 0;
        }
        // 计算左右子树的深度
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // 把深度返回（要加上自己的深度）
        return Integer.max(left, right) + 1;
    }

    /*
     * 后序遍历的思路是先遍历左子树，把遍历的节点存储到一个栈中，等到遍历完左子树以后回头遍历根节点，再遍历右子树。
     * 如何判断一个栈顶的元素是不是需要遍历右子树？
     *       1：首先看他的右子树是不是空了，
     *       2：然后看他的右子树节点是不是遍历过了。使用一个peek变量实现，右子树遍历过肯定要出栈
     * */
    public int maxDepth2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();// 记录左子树遍历过程中的元素
        TreeNode curr = root; // 当前遍历的节点
        TreeNode pop = null;   // 记录最近一次出栈的
        int max = 0;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);   // 记录当前遍历过的位置
                if (stack.size() > max) {
                    max = stack.size();
                }
                curr = curr.left;
            } else {// 说明左子树遍历到头了，回头遍历根节点
                TreeNode peek = stack.peek();// 查看一下最近入栈的元素
                // 说明右子树这边不用遍历或者遍历过了
                if (peek.right == null || peek.right == pop) {
                    // 直接出栈
                    pop = stack.pop();
                    System.out.print(pop + "\t");
                } else {
                    // 继续往下遍历，更新curr
                    curr = peek.right;
                }
            }
        }
        return max;
    }

    /*
     * 这个解法使用层序遍历，即一层一层遍历。就是使用队列存储每一层的节点。在遍历时出队。
     *   求最大深度记录二叉树深度即可
     * */
    public int maxDepth3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int maxDepth = 0;
        queue.offer(root);  // 初始化
        while (!queue.isEmpty()) {
            int size = queue.size();  // 当前层的元素个数
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();// 出队元素
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            maxDepth += 1;
        }
        return maxDepth;
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
        System.out.println(new MaxDepth().maxDepth3(root));
    }
}
