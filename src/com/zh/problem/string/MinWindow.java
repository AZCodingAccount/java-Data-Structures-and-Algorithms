package com.zh.problem.string;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-16 19:57
 * @description: 最小覆盖子串——leetcode76
 **/
public class MinWindow {
    /*
            双指针策略，i指针负责缩小子串长度、j指针负责找到子串。
            ADOBECODEBANC
            1：初始化i，j均为0
            2：移动j指针，直到满足条件。如果满足长度更小，记录该子串start和length
            3：移动i指针，尝试减少子串长度，当不满足条件时，重复步骤2
            4：重复步骤2、3，直到j>s.length-1
     */
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        // minStart: 找到最优解的start    minLen：最小的覆盖子串长度、counter表示需要满足的条件
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        while (end < s.length()) {
            // 更新end
            char c1 = s.charAt(end);
            if (map[c1] > 0) counter--;
            map[c1]--;  // 这里会记录原始字符串的每个字符的出现个数 -1
            end++;
            // 更新start
            while (counter == 0) {
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }
                char c2 = s.charAt(start);
                map[c2]++;
                if (map[c2] > 0) counter++; // 说明窗口里面少了一个关键的字符
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }


    public static void main(String[] args) {
        System.out.println(new MinWindow().minWindow("a", "b"));
    }
}
