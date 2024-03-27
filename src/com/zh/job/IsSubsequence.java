package com.zh.job;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-27 14:52
 * @description: 判断子序列问题——leetcode392
 **/
public class IsSubsequence {
    /*
      两个字符串，左边一个指针，右边一个。
      1：碰到两个相等指针同时移动。 2：不然就移动长的字符串的指针，直到两个指针有任何一个指到头了
     */

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        if (t.isEmpty()) {
            return false;
        }
        int sP = 0, tP = 0;

        while (sP != s.length() && tP != t.length()) {
            if (s.charAt(sP) == t.charAt(tP)) { // 同时移动两个指针
                sP++;
                tP++;
            } else {
                tP++;
            }
        }
        // 判断找没找到子序列
        return sP == s.length();
    }

    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence("abc", "ahbgdc"));
    }
}
