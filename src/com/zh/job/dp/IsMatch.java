package com.zh.job.dp;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-28 21:45
 * @description: 正则表达式匹配—lc10
 **/
public class IsMatch {
    public boolean isMatch(String s, String p) {
        // dp[i][j]代表[0,i-1],[0,j-1]是否匹配
        // a a a
        // a a *
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // 初始化，解决 a c*a匹配的问题  因为在求dp[1][3]=dp[0][2], dp[0][x]默认都是false，就出现了问题
        for (int i = 1; i < n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        // 双层for循环遍历即可
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c = p.charAt(j - 1);
                if (Character.isLetter(c)) {  // 就是a，b，c这样的普通字符
                    if (c == s.charAt(i - 1)) dp[i][j] = dp[i - 1][j - 1];
                } else if (c == '.') {  // 谁都能匹配
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (c == '*') {
                    char pre = p.charAt(j - 2); // 正则里面的上一个字符
                    // 1：假如我一个都不匹配，带着前面那个字符一起消失，dp[i][j]=dp[i][j-2]
                    // 2：假如我只匹配一个，dp[i][j]=dp[i][j-1]
                    // 3：假如我匹配很多个，数学推导 dp[i][j]=dp[i-1][j]
                    if (pre == '.' || pre == s.charAt(i - 1)) {   // 只有两个相等时才进行匹配的判断，否则显然只能抛弃前面的字符
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
                    } else {    // 抛弃前面的字符
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new IsMatch().isMatch("a", "c*a"));
        System.out.println(new IsMatch().isMatch("aa", "a*"));
        System.out.println(new IsMatch().isMatch("ab", ".*"));
    }
}
