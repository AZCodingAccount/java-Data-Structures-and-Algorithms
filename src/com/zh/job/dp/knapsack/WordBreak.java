package com.zh.job.dp.knapsack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-24 17:35
 * @description: 单词拆分—lc139
 **/
public class WordBreak {
    /*
        完全背包问题，满足条件返回true和false，字符串分割还是挺难想的，外层遍历背包，内层遍历物品，这样才是排列
        dp[i]代表前i个字符是否可以被字典中的单词拼写
        dp[i]=wordDict.contains(s.substring(j,i))&&dp[j]
        (这里的j属于0-i，说明从0-i索引任何一个子字符串有一个满足，当前字符串就满足)
        这里也可以从wordDict里面枚举值，内层循环就是遍历wordDict
        dp[0]=true,无实际意义，其他初始化成false
        先遍历s，再遍历wordDict，
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        HashSet<String> set = new HashSet<>(wordDict);

        for (int i = 1; i <= s.length(); i++) { // 从1开始，因为切分的串包左不包右
            for (int j = 0; j < i; j++) {
                // 切分出一个子串
                String str = s.substring(j, i);    // 切分
                if (set.contains(str) && dp[j]) {
                    // 这个子串包含在wordDict中，并且之前的字符也可以被拼写
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    /*
        内层循环枚举wordDict
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        HashSet<String> set = new HashSet<>(wordDict);

        for (int i = 0; i <= s.length(); i++) {
            for (String string : wordDict) {
                // 切分出一个子串
                if (i >= string.length()) {
                    int leftIndex = i - string.length();
                    String str = s.substring(leftIndex, i);    // 切分
                    if (set.contains(str) && dp[leftIndex]) {
                        // 这个子串包含再wordDict中，并且之前的字符也可以被拼写
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("leetcode", List.of("leet", "code")));
    }
}
