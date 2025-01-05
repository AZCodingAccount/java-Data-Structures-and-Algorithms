package com.zh.codetop;

import com.zh.datastructures.tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-14 21:11
 * @description:
 **/
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            LinkedList<Integer> layer = new LinkedList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode polled = queue.poll();
                if (res.size() % 2 == 0) {
                    layer.offerLast(polled.val);
                } else {
                    layer.offerFirst(polled.val);
                }
                if (polled.left != null) {
                    queue.offer(polled.left);
                }
                if (polled.right != null) {
                    queue.offer(polled.right);
                }

            }
            res.add(layer);
        }
        return res;
    }
}
