package com.zh.job.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-23 16:31
 * @description: 验证二叉搜索树—lc98
 **/
public class IsValidBST {
    /*
                验证是否是二叉搜索树，使用中序遍历。二叉搜索树的充要条件是中序遍历结果有序。
       这个时候可以直接遍历完毕判断中序遍历数组是否有序，也可以遍历时候记录前一个节点。发现只要不是单调递增就return false。
       不要这样处理，一个节点只跟左节点和右节点比较，因为不能考虑左边节点都大于当前节点，右边节点都小于当前节点。
     */
    TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) { // 搜索到叶子节点了
            return true;
        }

        // 继续寻找左子树和右子树是否符合条件
        boolean leftFlag = isValidBST(root.left);
        if (pre != null && pre.val >= root.val) {
            return false;   // 之前节点大于当前节点，不符合二叉搜索树定义
        }
        pre = root;
        boolean rightFlag = isValidBST(root.right);
        return leftFlag && rightFlag;
    }
}
