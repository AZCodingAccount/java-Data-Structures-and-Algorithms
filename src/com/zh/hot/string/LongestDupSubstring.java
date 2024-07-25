package com.zh.hot.string;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-25 21:43
 * @description: 最长重复子串—lc1044
 **/
public class LongestDupSubstring {
    public String longestDupSubstring(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            while ((i + ans.length() + 1) <= s.length() && s.indexOf(s.substring(i, i + ans.length() + 1), i + 1) != -1) {
                // 保证不越界，并且看看后面能不能扩展
                ans = s.substring(i, i + ans.length() + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LongestDupSubstring().longestDupSubstring("banana"));
    }
}
