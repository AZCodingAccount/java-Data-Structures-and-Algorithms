package com.zh.codetop;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-12-02 00:16
 * @description:
 **/
public class ReverseWords {
    public String reverseWords(String s) {
        String[] split = s.strip().split("\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
