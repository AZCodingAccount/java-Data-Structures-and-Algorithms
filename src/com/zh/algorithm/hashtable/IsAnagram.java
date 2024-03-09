package com.zh.algorithm.hashtable;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-05 21:30
 * @description: 判断两个字符串是否是字母异位词—leetcode242题
 **/
public class IsAnagram {
    /*
            给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
            注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
            两种解法：
                1：对两个字符串进行字符的排序，然后直接比较排序后的字符串是否相等
                2：定义一个bitmap，长度为26，比较时候遍历26的bitmap数组即可
     */
    public boolean isAnagram(String s, String t) {
        // 转换成字符数组
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        // 对字符数组排序
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);
        // 比较排序后的字符串是否相等
        return new String(sCharArray).equals(new String(tCharArray));
    }

    // 使用位数组判断
    public boolean isAnagram2(String s, String t) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 97]++;
        }
        for (char c : t.toCharArray()) {
            count[c - 97]--;
        }
        // 判断count数组是不是全是0，如果有一个不为0，说明不是字母互位词
        return Arrays.stream(count).noneMatch(i -> i != 0);
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(new IsAnagram().isAnagram2(s, t));    // true
        s = "rat";
        t = "car";
        System.out.println(new IsAnagram().isAnagram2(s, t));    // false
    }
}
