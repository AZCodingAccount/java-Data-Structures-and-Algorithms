package com.zh.job.greedy;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-29 18:13
 * @description: 监控二叉树—lc968
 **/
public class MinCameraCover {
    /*
        监控二叉树，使用贪心的方法解决的思路是在叶子节点的上层放一个摄像头，然后直到遍历到根节点。状态转移有三种
        1：有覆盖：孩子节点有摄像头
        2：无覆盖：孩子节点是有覆盖，摄像头没有覆盖到
        3：有摄像头：影响下一个节点是有覆盖。
        这里使用后序遍历，依次从下往上处理每一个节点

     */
    int res = 0;

    public int minCameraCover(TreeNode root) {
        int state = postOrder(root);
        if (state == 2) {   // 第四种情况，遍历到根节点了，根节点没有被覆盖
            res++;
        }
        return res;
    }

    private int postOrder(TreeNode curr) {
        if (curr == null) return 1; // 空节点返回有覆盖，这样叶子结点才能是无覆盖的状态
        int left = postOrder(curr.left);
        int right = postOrder(curr.right);
        // 按道理有6种状态，实际上不用处理那么多


        if (left == 2 || right == 2) {  // 孩子有一个没有被覆盖(当然包含了left=2,right=2，都没有被覆盖的情况)
            res++;      // 放置摄像头
            return 3;   // 返回当前是有摄像头的状态
        } else if (left == 3 || right == 3) { // 有一个孩子有摄像头（当然包含了left=3,right=3，都有摄像头的情况）
            return 1;   // 有覆盖
        } else { // 两个孩子都被覆盖了，因为前面的||把其他的比如一个孩子被覆盖，一个孩子有摄像头这种情况包含了
            return 2;   // 无覆盖
        }
    }
}
