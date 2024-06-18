package com.zh.job.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-18 20:19
 * @description: 路径总和—lc112
 **/
public class HasPathSum {
    /*
        这个类似于上次那个求路径的，都是一样的，使用前序遍历遍历一次路径即可，这次把pathSum定义为成员变量试一下
     */
    int pathSum;    // 当前路径的总和，注意回溯时候把这个减掉，如果是方法参数可以不减

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) { // 初始条件
            return false;
        }
        if (root.left == null && root.right == null) {  // 出口
            return pathSum + root.val == targetSum;   // +root.val是因为简写了，实际上要先+，然后判断相等以后再减掉。这里偷了个懒
        }
        pathSum += root.val; // 中
        boolean lSum = hasPathSum(root.left, targetSum);    // 左
        boolean rSum = hasPathSum(root.right, targetSum);   // 右
        pathSum -= root.val;    // 回溯
        return lSum || rSum;
    }
}
