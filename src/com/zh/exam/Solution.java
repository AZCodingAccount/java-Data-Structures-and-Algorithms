package com.zh.exam;

import com.zh.datastructures.tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<LinkedList<Integer>> res = new LinkedList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        dfs(root, 0);
        return new ArrayList<>(res);
    }

    public void dfs(TreeNode node, int depth) {
        if (node == null) return;
        if (res.size() <= depth) {
            res.add(new LinkedList<>());
        }
        if (depth % 2 == 0) {
            res.get(depth).offerLast(node.val);
        } else {
            res.get(depth).offerFirst(node.val);
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}