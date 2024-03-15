package com.zh.algorithm.divideconquer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-14 13:46
 * @description: 至少有K个重复字符的最长子串——leetcode395
 **/
public class LongestSubstring {
    /*
                给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
            如果不存在这样的子字符串，则返回 0。
            考虑一个字符串s
                1：筛选出每个字符出现次数<k的
                2：根据这些字符进行分割（优化思路，排除连续的不满足条件的字符），递归的处理分割出来的子串
                3：结束条件是不能再分割了，找到了一个字符，返回长度即可
            优化：
                1：不用再筛选了，遍历字符串的每个字符，对每个字符单独判断满不满足要求
     */


    public int longestSubstring(String s, int k) {
        if (s.length() < k) return 0;
        char[] chs = s.toCharArray();
        // 统计个数
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : chs) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        // 筛选元素
        // 优化，处理像这样的字符串aaaaaaaaaaaabcdefghijklmnopqrstuvwzyz避免重复计算
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) < k) { // 处理当前这个字符
                int n = i + 1;    // 切分的指针右指针
                // aaabceaa
                while (n < s.length() && map.get(s.charAt(n)) < k) {
                    n++;
                }
                // 递归调用这两串，注意，这里的s是更新的，所以使用0->i  n->s.length完全没有问题。
                // 假设最后一个不满足要求，不用分割 (7,7)分割是空串
                return Math.max(longestSubstring(s.substring(0, i), k), longestSubstring(s.substring(n), k));
            }
        }
        // 说明这个字符串没有进去过if的逻辑，字符串满足要求
        return s.length();
    }

    public static void main(String[] args) {

        System.out.println(new LongestSubstring().longestSubstring("weitong", 2));
    }
}
