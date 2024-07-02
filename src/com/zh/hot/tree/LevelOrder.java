package com.zh.hot.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-02 13:20
 * @description: 层序遍历—lc102
 **/
public class LevelOrder {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            List<Integer> layer = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                layer.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(layer);
        }
        return res;
    }

    // 递归遍历，需要借助一个层级
    public List<List<Integer>> levelOrder2(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int layer) {
        if (root == null) return;
        if (layer >= res.size()) res.add(new ArrayList<>());
        res.get(layer).add(root.val);
        dfs(root.left, layer + 1);
        dfs(root.right, layer + 1);
    }
}
