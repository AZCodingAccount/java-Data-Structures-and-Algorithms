package com.zh.job.str;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-16 17:35
 * @description: 翻转字符串—lc344
 **/
public class ReverseString {

    /**
     * 双指针遍历即可
     **/
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
    }
}
