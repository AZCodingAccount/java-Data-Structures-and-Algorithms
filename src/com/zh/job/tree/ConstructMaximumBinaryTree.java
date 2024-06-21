package com.zh.job.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-21 16:39
 * @description: 构造最大二叉树—lc654
 **/
public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int maxIndex = 0; // 最大数的索引
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxNum);
        if (nums.length == 1) { // 说明没有子节点了，提前退出
            return root;
        }
        // 切分左边数组和右边数组
        int[] leftNums = Arrays.copyOfRange(nums, 0, maxIndex);
        int[] rightNums = Arrays.copyOfRange(nums, maxIndex + 1, nums.length);
        root.left = constructMaximumBinaryTree(leftNums);
        root.right = constructMaximumBinaryTree(rightNums);
        return root;
    }
}
