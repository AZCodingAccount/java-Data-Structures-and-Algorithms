package com.zh.job.dp;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-04-11 14:17
 * @description: 最长有效括号——lc32
 **/
public class LongestValidParentheses {
    /*      0 1 2 3 4 5
            ( ( ) ( ) )
            0 0 2 0 4 6
                使用dp求解的话，dp[i]代表以第i个元素结尾时的有效子串长度。初始化为 ( 时，dp[i]=0
            如果为 ) 时，
            if dp[i-1-dp[i-1]]=(    dp[i]=dp[i-1]+2
            else dp[i]=0
     */

    public int longestValidParentheses(String s) {
        char[] chs = s.toCharArray();
        int[] dp = new int[chs.length + 1];
        for (int i = 1; i < chs.length + 1; i++) {
            if (chs[i - 1] == '(') {    // 左括号
                dp[i] = 0;
            } else {    // 右括号
                // 正常处理右括号，首先判断当前能不能延伸，不能延伸初始化成0
                if (i - 2 - dp[i - 1] >= 0 && chs[i - 2 - dp[i - 1]] == '(') {    // (()
                    dp[i] = dp[i - 1] + dp[i - 2 - dp[i - 1]] + 2;  // ()() i=4   以索引为5的为例，dp[i]的值三部分，
                    // 第一部分来源于结合的左右括号，第二部分来源于可能被包裹的右括号dp[i-1]   第三部分来源于外部的拼接内容dp[i - 2 - dp[i - 1]]
                } else {
                    dp[i] = 0;
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses(")()())"));
    }
}
