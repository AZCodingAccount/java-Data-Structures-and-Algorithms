package com.zh.hot.dp;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-23 20:31
 * @description: 解码方法—lc91
 **/
public class NumDecodings {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int[] dp = new int[len];   // dp[i]代表从0-i解码的个数
        // dp[i]=dp[i-1]+dp[i-2]，保证s[i-1]为[1,9]之间、s[i-1]+s[i-1]为[10,26]之间
        int n = s.charAt(0) - '0';
        if (n >= 1 && n <= 9) {
            dp[0] = 1;
        }
        if (len > 1) {
            int num = Integer.parseInt(s.charAt(0) + "" + s.charAt(1));
            if (num >= 10 && num <= 26) {
                dp[1] = dp[0] + 1;
            } else {
                dp[1] = dp[0];
            }
        }
        for (int i = 2; i < len; i++) {
            int num1 = s.charAt(i) - '0';
            int num2 = Integer.parseInt(s.charAt(i - 1) + "" + s.charAt(i));
            if (num1 >= 1 && num1 <= 9) {
                dp[i] += dp[i - 1];
            }
            if (num2 >= 10 && num2 <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(new NumDecodings().numDecodings("12"));
    }
}
