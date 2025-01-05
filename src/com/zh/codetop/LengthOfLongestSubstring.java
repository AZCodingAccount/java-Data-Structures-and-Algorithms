package com.zh.codetop;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-06 23:42
 * @description:
 **/
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = Integer.MIN_VALUE, len = s.length();
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0;
        while (left <= right && right < len) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                maxLen = Math.max(maxLen, right - left);
            } else {
                // 移动left指针直到可以装下右边的字符
                while (set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left++));
                }
            }
        }
        return maxLen;
    }
}
