package com.zh.job.dp;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-21 14:46
 * @description: 不同的二叉搜索树—lc96
 **/
public class NumTrees {
    /*
        考虑固定一个，确定左子树和右子树。
        dp[i]含义：dp[i]代表由n个节点组成的二叉搜索树种类
        递推式： dp[i]=sum(dp[j-1]*dp[i-j])  j从1取到n，至于为什么是j-1和i-j，考虑二叉搜索树左子树和右子树性质
        初始化：dp[0]=1,(想象一下左边0节点右边n-1个节点的情况),dp[1]=1
        遍历： 从n=2开始遍历，最后返回dp[n]
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
