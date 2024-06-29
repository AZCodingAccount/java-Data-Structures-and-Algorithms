package com.zh.job.dp;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-29 20:44
 * @description: 回文子串的个数—lc649
 **/
public class CountSubstrings {
    /*
        这种求个数的适合使用dp来解决，但是这个比较绕，记住就可以了
    dp含义
        dp[i][j]代表从[i,j]的子串是不是回文子串
    递推式
        aba
        aa
        if(s[i]==s[j]) dp[i][j]=dp[i+1][j-1]
        当i==j的时候a是回文子串 i+1=j的时候aa是回文子串 其他情况 aba这里依赖前一个状态即可
    初始化
        全部初始化成false
    遍历顺序
        外层i，内层j，i从s.length-1——>0，j从i到s.length-1
    最后返回res
     */
    public int countSubstrings(String s) {
        int res = 0;
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        // 实际上就是从三层for简化成了两层for，使用dp记录之前搜索过的回文串
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j <= length - 1; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // 处理递推式的特殊情况，i=j-1的时候[i,j]已经越界了，特殊处理。i==j的时候可能出现i=length-1时i+1越界
                    if (i == j || i + 1 == j) dp[i][j] = true;
                    else dp[i][j] = dp[i + 1][j - 1];
                    if (dp[i][j]) res++;
                }
            }
        }
        return res;
    }
}
