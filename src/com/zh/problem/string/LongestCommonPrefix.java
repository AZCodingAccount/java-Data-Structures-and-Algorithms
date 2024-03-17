package com.zh.problem.string;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-16 17:26
 * @description: 最长公共前缀
 **/
public class LongestCommonPrefix {
    /*
            情况考虑完整
            flower
            flow
            flight
            1：匹配完成
            2：任意一个字符串长度不够

     */
    public String longestCommonPrefix(String[] strs) {
        int i = 0;
        int minLen = Integer.MAX_VALUE;
        // 求出字符串的最小长度
        for (String str : strs) {
            if (str.length() < minLen) minLen = str.length();
        }
        // 能否在长度够的情况下找到公共子串
        while (i < minLen) {
            char c = 0;
            for (String str : strs) {
                if (c == 0) {
                    c = str.charAt(i);
                } else {
                    if (c != str.charAt(i)) {
                        if (i == 0) return "";
                        return str.substring(0, i );
                    }
                }
            }
            i++;
        }
        // 长度不够跳出时判断存不存在公共前缀
        return strs[0].substring(0, i);

    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"dog", "dacecar", "dar"}));
    }
}
