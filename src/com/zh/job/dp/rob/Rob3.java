package com.zh.job.dp.rob;

import com.zh.datastructures.tree.binarytree.TreeNode;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-24 20:56
 * @description: 打家劫舍3—lc337
 **/
public class Rob3 {
    /*
        树形DP，使用后序遍历搜集结果
        dp[0]代表当前节点偷的最大价值，dp[1]代表不偷的最大价值。因为每个递归函数dp数组都是一个全新的
        max(curr.val+leftDP[1]+rightDP[1],max(leftDP[0],leftDP[1])+max(rightDP[0],rightDP(1)))
        偷当前节点就不能偷下面的左右孩子节点，是否偷左孩子节点，是否偷右孩子节点
        初始化就都初始化成0即可
        遍历顺序后序
     */

    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * 树形DP的递归函数(不要陷入一根筋两头堵的状况，仅仅考虑当前节点状态和子节点。不要关心子节点偷到哪了，父节点能不能偷这些)
     *
     * @param curr 当前处理的节点
     * @return 当前节点DP数组的值，最核心的东西
     */
    private int[] dfs(TreeNode curr) {
        if (curr == null) { // 遍历到叶子节点的孩子了
            return new int[]{0, 0};
        }
        int[] leftDP = dfs(curr.left);  // 左
        int[] rightDP = dfs(curr.right);    // 右

        int currVal = curr.val + leftDP[1] + rightDP[1];  // 偷当前节点
        // 不偷当前节点
        int childrenVal = Math.max(leftDP[0], leftDP[1]) + Math.max(rightDP[0], rightDP[1]);

        return new int[]{currVal, childrenVal};
    }
}
