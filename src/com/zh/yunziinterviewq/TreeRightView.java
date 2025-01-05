package com.zh.yunziinterviewq;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-12-06 16:18
 * @description:
 **/
public class TreeRightView {
   static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode( TreeNode left,int val, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<Integer> res = new ArrayList<>();

    public List<Integer> rightView(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode polled = queue.poll();
                if (size == 0) res.add(polled.val);
                if (polled.left != null) {
                    queue.offer(polled.left);
                }
                if (polled.right != null) {
                    queue.offer(polled.right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = new TreeRightView().rightView(new TreeNode(new TreeNode(null, 2, new TreeNode(null, 5, null)),
                1,
                new TreeNode(null, 3, new TreeNode(null, 4, null))));
        System.out.println(list);
    }


}
