package com.zh.algorithm.hashtable;

import java.util.HashMap;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-05 15:15
 * @description: 力扣第3题——最长不重复子串
 **/
public class LengthOfLongestSubstring {
    /*
            非常经典的题目，最长不重复子串、重复子串等等，解题的思路都是一样的，使用hash表存字符、索引，遍历即可
     */
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> chsMap = new HashMap<>();
        /*  双指针问题，定义一个start和一个end，维护这两个指针即可，并判断start-end之间的字符串跟要检测的字符的重复。
            使用hash表，可以这么解决，key为字符、value为索引位置，对每个字符，只需要维护start就可以了,end就是遍历时的索引
         */
        int start = 0;  // 初始化头指针
        int maxLength = 0; // 初始化最长不重复子串长度
        // 遍历数组
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            // 说明重复了，更新start和存储的字符索引
            if (chsMap.containsKey(ch)) {
                start = Math.max(start, chsMap.get(ch) + 1);
                /* 可能存在特殊情况，"abba"，对最后一个字符a，因为前面的a索引是0,但是这个时候start已经是2了，直接开历史倒车是不对的。
                 解决方法
                    1：求两者的最大值，
                    2：维护哈希表，让哈希表存储的始终是前一个子串的元素。这个开销大但相对优雅。
                      实现就是每次更新最大长度时根据求出的区间范围对哈希表进行全量的更新
                 */
                chsMap.put(ch, end);
            } else {
                // 未重复，start不变，把这个字符加入哈希表
                chsMap.put(ch, end);
            }
            maxLength = Math.max(maxLength, end - start + 1); // 更新最大长度
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int length = new LengthOfLongestSubstring().lengthOfLongestSubstring(s);
        System.out.println(length);
    }
}
