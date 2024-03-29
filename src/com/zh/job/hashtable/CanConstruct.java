package com.zh.job.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-29 15:38
 * @description: 赎金信——leetcode383
 **/
public class CanConstruct {
    /*
       `  赎金信遍历两次，时间复杂度O(n)
    */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];

        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        // 剪枝判断
        for (char c : ransomNote.toCharArray()) {
            if ((cnt[c - 'a']--) - 1 < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CanConstruct().canConstruct("a", "b"));
    }
}
