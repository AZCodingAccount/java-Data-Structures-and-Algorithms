package com.zh.hot.dp;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-02 10:40
 * @description: 最长回文子串—lc5
 **/
public class LongestPalindrome {
    /*
        动态规划
        dp[i][j]代表[i,j]最长的回文子串长度
    递推公式
        if(s[i-1]==s[j-1]) i==j dp[i][j]=1    dp[i][j]=dp[i+1][j-1]+2
        注意相等的处理，两个特殊赋值和>0一个不能少，跟回文子序列不一样
        else dp[i][j]=0;
    初始化
        都初始化成0即可
     */
    public String longestPalindrome(String s) {
        int length = s.length();
        int[][] dp = new int[length ][length ];
        int left = 0, right = 0;    // 记录子串的left和right
        for (int i = length-1; i >= 0; i--) {
            for (int j = i; j < length ; j++) {
                if (s.charAt(i ) == s.charAt(j)) {
                    if (i == j) dp[i][j] = 1;
                    else if(i==j-1) dp[i][j]=2;
                    else if (dp[i + 1][j - 1] > 0) dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = 0;
                }
                if ((right - left + 1) <= dp[i][j]) {  // 字符串的最大长度可以更新了
                    left = i ;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("aacabdkacaa"));
    }
}
