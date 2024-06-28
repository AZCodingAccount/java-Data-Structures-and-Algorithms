package com.zh.job.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-28 21:42
 * @description: 将有序数组转换成二叉搜索树—lc108
 **/
public class SortedArrayToBST {
    /*
      题目中要求是平衡二叉搜索树，完全可以通过二分，然后进行一步一步取，左节点右节点变成平衡，因为二分，左右两边不会少于1
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        int left = 0, right = nums.length-1;
        return dfs(nums, left, right);
    }

    /**
     * 递归进行二叉树的赋值
     *
     * @param nums
     * @param left  数组的左索引
     * @param right 数组的右索引
     * @return
     */
    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) return null;  // 等于代表处理某一节点
        int mid = (left + right) / 2;   // 求中位数
        TreeNode root = new TreeNode(nums[mid]);
        // 构造左子树
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);
        return root;
    }
}
