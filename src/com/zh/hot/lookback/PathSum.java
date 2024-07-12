package com.zh.hot.lookback;

import com.zh.datastructures.tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-12 17:17
 * @description: 路径总和
 **/
public class PathSum {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> deque = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, 0, targetSum);
        return res;
    }

    private void dfs(TreeNode node, int sum, int targetSum) {
        if (node == null) return;   // 一边高一边低的情况
        if (node.left == null && node.right == null) {  // 叶子节点而非下一个节点
            if (sum == targetSum - node.val) {
                res.add(new ArrayList<>(deque));
            }
            return;
        }

        for (int i = 0; i < 2; i++) {
            deque.offerLast(node.val);
            if (i == 0) {   // 往左边走
                dfs(node.left, sum + node.val, targetSum);
            } else {
                dfs(node.right, sum + node.val, targetSum);
            }
            deque.pollLast();
        }
    }
}
