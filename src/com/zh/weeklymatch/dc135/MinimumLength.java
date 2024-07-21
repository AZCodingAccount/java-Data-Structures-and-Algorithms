package com.zh.weeklymatch.dc135;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-20 23:01
 * @description: 操作后字符串的最短长度—135双周赛第二题
 **/
public class MinimumLength {
    public int minimumLength(String s) {
        int len = s.length(), res = len;
        int[] map = new int[26];
        // 记录每个字符的所有出现位置
        for (int i = 0; i < len; i++) {
            map[s.charAt(i) - '0']++;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] >= 3) {
                if (map[i] % 2 == 0) res -= (map[i] - 2);   // 偶数留下两个，奇数留下一个
                else res -= (map[i] - 1);
            }
        }
        return res;
    }
}
