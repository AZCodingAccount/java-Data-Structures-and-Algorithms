package com.zh.job.tree;

import com.zh.datastructures.tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-23 17:23
 * @description: 二叉搜索树中的众数—lc501
 **/
public class FindMode {
    /*
        中序遍历，记录当前元素的频率，如果这个频率大于之前的频率，清除所有元素
     */
    LinkedList<Integer> res = new LinkedList<>();
    TreeNode pre = null;    // 遍历的当前节点
    int count = 0;          // 当前遍历元素的count值
    int maxCount = 0;       // 当前已知的最大频率

    public int[] findMode(TreeNode root) {
        dfs(root);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 遍历函数
     *
     * @param curr
     */
    private void dfs(TreeNode curr) {
        if (curr == null) {
            return;
        }
        dfs(curr.left); // 左子树
        // 1: 如果是正常的累加
        if (pre == null || pre.val == curr.val) {
            count++;
        } else {  // 2: 出现了拐点
            count = 1;  // 重置计数器
        }
        // 3: 走判断的逻辑，无论是正常的累加还是刚进来
        if (count >= maxCount) {   // 更新最大值
            if (count > maxCount) { // 清空之前的结果
                res.clear();
            }
            res.push(curr.val);
            maxCount = count;
        }
        pre = curr;
        dfs(curr.right);
    }
}
