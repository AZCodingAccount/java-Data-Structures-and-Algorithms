package com.zh.job.dp.subsequence;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-28 16:41
 * @description: 两个字符串的删除操作—lc583
 **/
public class MinDistance {
    /*
        返回最小的删除次数，可以求最小公共子序列，然后(两个串相加-2*公共子序列长度)/2就是最小的编辑距离，这里还是dp
    dp含义：
        dp[i][j]代表使前i-1个元素与前j-1个元素相等的最小步数
    递推式
        if(chs[i]==chs[j]) dp[i][j]=dp[i-1][j-1]    不删除任何字符
        else dp[i][j]=max(dp[i-1][j]+1,dp[i][j-1]+1)    删除s1前一个字符或s2的前一个字符。
        还有一个情况是删除两个字符，这种情况被之前的情况包含了
    初始化
        第0行初始化成j、第0列初始化成i，其他都初始化成0，注意初始化的讲究，这个影响最终结果
    遍历顺序
        两个字符串长度for循环遍历，最后返回dp[s1.length][s2.length]，代表都考虑完了
     */

    public int minDistance(String word1, String word2) {
        char[] chs1 = word1.toCharArray();
        char[] chs2 = word2.toCharArray();
        int len1 = chs1.length, len2 = chs2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (i == 0) dp[i][j] = len2;
                else if (j == 0) dp[i][j] = len1;
                else if (chs1[i-1] == chs2[j-1]) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
            }
        }
        return dp[len1][len2];
    }
}
