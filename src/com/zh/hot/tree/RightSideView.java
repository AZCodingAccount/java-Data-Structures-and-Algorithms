package com.zh.hot.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-04 15:16
 * @description: 二叉树的右视图
 **/
public class RightSideView {
    /*
        层序遍历，每次选最右边的
     */

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode polled = deque.poll();
                if (size == 0) res.add(polled.val); // 最右边的元素
                // 继续向下遍历
                if (polled.left != null) deque.offer(polled.left);
                if (polled.right != null) deque.offer(polled.right);
            }
        }
        return res;
    }


}
