package com.zh.job.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-18 16:22
 * @description: 二叉树的所有路径—lc257
 **/
public class BinaryTreePaths {
    /*
        这个递归也可以把res和path搞成一个成员变量，然后path使用一个StringBuilder，这样可能快一点吧，
      虽然+编译器也会优化，但是sb对象会创建很多，别问我为什么不那么写，因为我只击败了27%的人才想起来可以这么优化。
     */

    /**
     * 显然使用前序遍历，因为使用中序或者后序你就没办法记录第一个遍历的顺序了
     **/
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        String path = "";
        dfs(root, res, path);
        return res;
    }

    /**
     * 前序遍历这个二叉树
     *
     * @param node 当前处理的节点
     * @param res  结果集
     * @param path 当前的路径
     */
    private void dfs(TreeNode node, ArrayList<String> res, String path) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {  // 遍历到头了，可以把这个path给加进来
            path += node.val;
            res.add(path);
            path = "";  // 重置path
        }
        // 前序遍历，中左右
        path += node.val;
        path += "->";
        dfs(node.left, res, path);    // 遍历左子树
        dfs(node.right, res, path);   // 遍历右子树
    }
}
