package com.zh.codetop;

import com.zh.datastructures.tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-20 00:25
 * @description:
 **/
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode polled = queue.poll();
                if (size == 0) res.add(polled.val);
                if (polled.left != null) queue.offer(polled.left);
                if (polled.right != null) queue.offer(polled.right);
            }
        }
        return res;
    }
}
