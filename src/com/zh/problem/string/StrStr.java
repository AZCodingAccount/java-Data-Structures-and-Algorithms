package com.zh.problem.string;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-16 17:00
 * @description: 找出字符串第一个匹配项的下标——leetcode28
 **/
public class StrStr {
    /*
            暴力解法+KMP匹配
            sadbutsad
            sad
            i
            j
            暴力：定义双指针，i表示已检测的索引，j表示匹配子串的进度（0-needle.length）。不停匹配即可
     */
    public int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length()) return -1;    // 处理特殊情况
        // 转成数组快一点
        char[] origin = haystack.toCharArray();
        char[] pattern = needle.toCharArray();
        int i = 0, j = 0;
        while (true) {
            // 模式匹配与原字符串
            for (int i1 = 0; i1 < needle.length(); i1++) {
                if (origin[i + i1] == pattern[i1]) {
                    j++;
                } else {
                    break;
                }
            }
            if (j == needle.length()) {
                // 找到了第一个解
                return i;
            } else if (i == haystack.length() - needle.length()) {
                // 遍历到最后也没找到
                break;
            }
            i++;    // 移动原始字符串位置
            j = 0;  // 清空统计值
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new StrStr().strStr("sabutsad", "sad"));
    }
}
