package com.zh.job.origin;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-25 11:35
 * @description: 翻转字符串中的单词—leetcode151
 **/
public class ReverseWords {

    public String reverseWords(String s) {
        String[] split = s.strip().split(" +");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("  hello world  "));
    }
}
