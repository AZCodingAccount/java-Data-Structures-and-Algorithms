package com.zh.job.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-23 17:09
 * @description: 二叉搜索树的最小绝对差—lc530
 **/
public class GetMinimumDifference {
    /*
        依然是中序遍历，实际上先序也行。就是判断当前节点和上一个节点的最小值，然后记录下来
     */

    int res = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;   // 避免影响之前正确的结果
        }

        int leftRes = getMinimumDifference(root.left);
        // 对中间节点处理
        if (pre != null) {
            res = Math.min(root.val - pre.val, res);
        }
        pre = root;
        int rightRes = getMinimumDifference(root.right);
        return Math.min(res, Math.min(leftRes, rightRes));
    }

    public static void main(String[] args) {
        System.out.println(new GetMinimumDifference().getMinimumDifference(new TreeNode(
                new TreeNode(new TreeNode(null, 1, null), 2, new TreeNode(null, 3, null))
                , 4
                , new TreeNode(null, 6, null))
        ));
    }
}
