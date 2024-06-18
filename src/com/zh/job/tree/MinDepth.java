package com.zh.job.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-18 12:06
 * @description: 二叉树的最小深度—lc111
 **/
public class MinDepth {
    /**
     * 需要注意最小深度的定义，限制了到叶子节点，因此比如左子树为空，右子树很多节点就只能从右子树找了
     * 这里还有另一个写法，就是递归之前判断一下（把左子树为空或者右子树为空的两个特殊情况处理一下），就不用中间那个return 1的情况了
     **/
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 避免一个子树为空的情况，要不直接root==null返回0也可以
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            int curr = minDepth(root.left);
            if (curr < min) {
                min = curr;
            }
        }
        if (root.right != null) {
            int curr = minDepth(root.right);
            if (curr < min) {
                min = curr;
            }
        }
        return min + 1;
    }
}
