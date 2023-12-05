package com.zh.algorithm.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-12-05 19:10
 * @description: 判断是否是对称二叉树—leetcode101 递归求解
 **/
public class IsSymmetric {

    /*
    使用递归求解
    * 1：如果左子树和右子树均为空了，就返回true
    * 2：左右子树有一个为空，另外一个不为空，就返回false
    * 3：判断当前节点的值，如果值不同，也返回false。
    * 4：上面的都不满足，递归寻找左子树的左节点和右子树的右节点。左子树的右节点和右子树的左节点。
    * */
    public boolean isSymmetric(TreeNode root) {
        return judgeSymmetric(root.left, root.right);
    }

    private boolean judgeSymmetric(TreeNode left, TreeNode right) {
        // 代表前面的不等条件全不满足，就可以认为是对称了（当然多层的话还有其他判断的分支）
        if (left == null && right == null) {
            return true;
        }
        // 如果能走到这里，说明两个一定不会同时为null，那么left==null就隐藏了right！=null
        if (left == null || right == null) {
            return false;
        }
        // 说明二者肯定都不为null
        if (left.val != right.val) {
            return false;
        }
        // 两者同时成立才可以认为是对称
        return judgeSymmetric(left.left, right.right) && judgeSymmetric(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(null, 3, null), 2, new TreeNode(null, 4, null)),
                1,
                new TreeNode(new TreeNode(null, 4, null), 2, new TreeNode(null, 3, null))
        );
        System.out.println(new IsSymmetric().isSymmetric(root));
    }
}
