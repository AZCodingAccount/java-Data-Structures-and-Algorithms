package com.zh.hot.doublep;

import java.util.HashSet;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-30 16:57
 * @description: 无重复字符的最长子串—lc3
 **/
public class LengthOfLongestSubstring {
    /*
        使用一个map，不想写思路了，反正也会忘，就是双指针
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, maxLen = 0;
        HashSet<Character> set = new HashSet<>();
        int strLeft = 0, strRight = 0;
        while (right < s.length()) {  // 不需要判断left和right，因为left不可能超过right
            // 不断移动左指针，直到可以把当前元素放进去
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left)); // 移动元素
                left++;     // 移动指针
            }
            // 放入当前元素
            set.add(s.charAt(right));
            right++;
            if (set.size() > maxLen) {
                maxLen = set.size();
                strLeft = left;
                strRight = right;
            }
            maxLen = Math.max(maxLen, set.size());
        }
        // 输出一个长度最大的字符串（如果需要多个，使用List记录，最后遍历list）
        System.out.println(s.substring(strLeft, strRight));
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
    }
}
