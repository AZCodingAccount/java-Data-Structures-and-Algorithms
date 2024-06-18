package com.zh.job.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-18 16:47
 * @description: 左叶子之和—lc404
 **/
public class SumOfLeftLeaves {
    /*
       关键在于如何判断是左叶子，两个条件，一个是叶子节点，一个是父节点的左孩子。
        1：叶子节点通过左孩子和右孩子为空判断。2：左：在父节点就判断自己的左孩子是不是叶子节点，当然也可以加一个标志位标记是左孩子
        且遍历使用后序遍历
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lCount = 0; // 需要注意的是这里不能立即返回，不然右子树就没遍历到了
        if (root.left != null && root.left.left == null && root.left.right == null) {
            // 左子树只有一个节点了，自然跟下面的递归方法是if else关系
            lCount = root.left.val;
        } else {
            lCount = sumOfLeftLeaves(root.left);
        }

        int rCount = sumOfLeftLeaves(root.right);
        return lCount + rCount;
    }
}
