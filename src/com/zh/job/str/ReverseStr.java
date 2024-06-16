package com.zh.job.str;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-16 18:33
 * @description: 反转字符串2—lc541
 **/
public class ReverseStr {
    /**
     * 就是一个字符串模拟题，不应该反转单个子串的，写的一坨shit😭
     **/
    public String reverseStr(String s, int k) {
        int len = s.length();
        // String newStr = ""; // 处理完成的字符
        int m = len;  // 还剩下的字符串长度
        // 当还可以处理时
        while (m >= 2 * k || (m < 2 * k && m >= k)) {
            // 翻转前k个字符
            char[] chars = s.substring(len - m, len - m + k).toCharArray();
            reverseString(chars);
            // 拼接反转好的
            s = s.substring(0, len - m).concat(String.valueOf(chars)).concat(s.substring(len - m + k));
            if (m >= 2 * k) {
                m -= 2 * k;
            } else {
                m = 0;
            }
        }
        if (m < k) {    // 剩下字符少于k个
            // 翻转前k个字符
            char[] chars = s.substring(len - m ).toCharArray();
            reverseString(chars);
            // 拼接反转好的
            s = s.substring(0, len - m).concat(String.valueOf(chars));
        }
        return s;
    }

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ReverseStr().reverseStr("abcdefg", 2));
    }
}
