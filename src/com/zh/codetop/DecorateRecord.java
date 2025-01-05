package com.zh.codetop;

import com.zh.datastructures.tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-12-15 00:25
 * @description:
 **/
public class DecorateRecord {
    List<LinkedList<Integer>> res = new ArrayList<>();

    public List<List<Integer>> decorateRecord(TreeNode root) {
        dfs(root, 0);
        return res.stream().map(item->new ArrayList(item)).collect(Collectors.toList());
    }

    public void dfs(TreeNode node, int depth) {
        if (node == null)
            return;
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
