package com.zh.job.dp.subsequence;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-28 10:22
 * @description: 不同的子序列—lc115
 **/
public class NumDistinct {
    /*
        两个子序列同样适用dp[i][j]。这个问题就是模拟删除元素  rabb   rab
        if(nums[i-1]==nums[j-1]) dp[i][j]=dp[i-1][j-1]+dp[i-1][j] 如果当前字符相等，继承rab、ra 和 rab、rab两种状态之和
        else dp[i][j]=dp[i-1][j]    当前不相等，相当于删除大的字符串中的字符，也可以认为跳过这个字符
        j==0时，都初始化成1。其他初始化成0。如何理解，当小的子序列为空串的时候，大的子序列也应该包含一个空串。
        考虑rar和r这一个子串，dp[3][1]应该等于2，初始化成1使得dp[2][0]=1,又dp[2][1]=dp[1][1]=1,此时可以得到正确的结果
        外层s.length，内层t.length
     */
    public int numDistinct(String s, String t) {
        char[] chs1 = s.toCharArray();
        char[] chs2 = t.toCharArray();
        int[][] dp = new int[chs1.length + 1][chs2.length + 1];
        for (int i = 0; i <= chs1.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= chs1.length; i++) {
            for (int j = 1; j <= chs2.length; j++) {
                if (chs1[i - 1] == chs2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[chs1.length][chs2.length];
    }

    public static void main(String[] args) {
        System.out.println(new NumDistinct().numDistinct("rabbbit", "rabbit"));
    }
}
