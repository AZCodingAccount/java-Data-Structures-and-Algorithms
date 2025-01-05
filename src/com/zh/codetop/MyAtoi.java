package com.zh.codetop;

import java.util.HashMap;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-26 00:43
 * @description:
 **/
public class MyAtoi {
    public int myAtoi(String s) {
        int len = s.length();
        // 丢弃前导空格
        int idx = 0;
        while (s.charAt(idx) == ' ') idx++;
        int sign = 1;
        if (s.charAt(idx) == '-') {
            sign = -1;
            idx++;
        }
        long res = 0;
        for (int i = idx; i < len; i++) {
            // 53
            if (Character.isDigit(s.charAt(i))) {
                res = res * 10 + s.charAt(i) - '0';
                if (sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                else if (sign == -1 && -res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            } else {
                break;
            }
        }
        return sign * (int) res;
    }
}
