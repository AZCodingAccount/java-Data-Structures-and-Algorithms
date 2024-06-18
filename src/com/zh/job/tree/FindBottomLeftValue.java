package com.zh.job.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-18 18:13
 * @description: 找树左下角的值—lc513
 **/
public class FindBottomLeftValue {
    /*
        层序遍历是最简单的写法，易知左下角值一定在树的最深层。从左到右遍历即可。当然也可以从右往左遍历，就不用isFirst标记了，另外size也可以省去，
        因为size是记录每一层的
     */
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isFirst = true;
            while (size-- > 0) {
                TreeNode polled = queue.poll();
                if (isFirst) {
                    res = polled.val;
                    isFirst = false;
                }
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
}
