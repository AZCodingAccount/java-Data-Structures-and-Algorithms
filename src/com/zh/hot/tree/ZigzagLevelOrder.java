package com.zh.hot.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-02 20:22
 * @description: 二叉树的锯齿形层序遍历
 **/
public class ZigzagLevelOrder {
    List<LinkedList<Integer>> list = new LinkedList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // dfs(root, 0);
        LinkedList<TreeNode> deque = new LinkedList<>();
        if (root != null) deque.offer(root);
        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            LinkedList<Integer> layer = new LinkedList<>();
            while (size-- > 0) {
                TreeNode polled = deque.poll();
                // 处理当前节点
                if (level % 2 == 0) {
                    layer.offerLast(polled.val);
                } else {
                    layer.offerFirst(polled.val);
                }
                // 添加子节点到队列中
                if (polled.left != null) {
                    deque.offer(polled.left);
                }
                if (polled.right != null) {
                    deque.offer(polled.right);
                }
            }
            list.add(layer);
            level++;
        }
        return new ArrayList<>(list);
    }


    /*List<LinkedList<Integer>> list = new LinkedList<>();

    private void dfs(TreeNode root, int level) {
        if (root == null) return;

        if (level >= list.size()) {
            list.add(new LinkedList<>());
        }
        if (level % 2 == 0) list.get(level).offerLast(root.val);
        else list.get(level).offerFirst(root.val);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }*/
}
