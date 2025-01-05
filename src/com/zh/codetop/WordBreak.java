package com.zh.codetop;

import java.util.HashSet;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-12-12 22:16
 * @description:
 **/
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];    // 前[0,i-1]个元素是否可以被组成
        dp[0] = true;
        for (int i = 1; i < len + 1; i++) {
            for (int j = 0; j <= i; j++) {
                if (!dp[i] && dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
