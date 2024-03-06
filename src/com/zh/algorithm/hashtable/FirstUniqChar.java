package com.zh.algorithm.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-06 11:42
 * @description: 第一个唯一字符—leetcode387题
 **/
public class FirstUniqChar {
    /*
            给定一个字符串 s ，找到它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
                1：找到所有不重复的字符、从中找到第一个
                2：尽量找到前面的字符，判断是否重复
                两个解法都是一样的，使用哈希表即可。都是存储字符和字符出现的个数；
                    1：遍历字符数组填充哈希表
                    2：遍历字符数组找到索引
     */
    public int firstUniqChar(String s) {
        Map<Character, Integer> charsFrequencyMap = new HashMap<>();    // 哈希表
        char[] chs = s.toCharArray();   // 字符数组
        // 1：遍历数组填充哈希表
        for (char ch : chs) {
            Integer value = charsFrequencyMap.getOrDefault(ch, 0) + 1;
            charsFrequencyMap.put(ch, value);
        }
        // 2：遍历数组找到索引
        for (int i = 0; i < chs.length; i++) {
            if (charsFrequencyMap.get(chs[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "lleetcode";
        System.out.println(new FirstUniqChar().firstUniqChar(s));

    }
}
