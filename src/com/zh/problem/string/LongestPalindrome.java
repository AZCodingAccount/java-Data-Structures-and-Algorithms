package com.zh.problem.string;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-16 17:57
 * @description: 最长回文子串——leetcode5
 **/
public class LongestPalindrome {
    /*
            中间开花的方法，分奇偶两种情况
            babad
            cbbd
            奇数的时候，从0开始，分别比较左边和右边的，直到不相等或走到头
            偶数时候，从0、1开始，一直到头
            但是需要注意的是，这个所谓的奇偶是回文串，不是原始字符串
     */


    public String longestPalindrome(String s) {
        left = 0;
        right = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            work(s, i, i);
            work(s, i, i + 1);
        }
        return s.substring(left, right + 1);
    }

    static int left = 0;
    static int right = 0;

    /**
     * @param s 原始字符串
     * @param i 左指针
     * @param j 右指针
     * @return void
     * @author AlbertZhang
     * @description 对某一位置开始左右开花
     * @date 2024-03-16 18:04
     **/
    private void work(String s, int i, int j) {
        // 不断往左和右延伸
        while (i >= 0 && j <= s.length() - 1 && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        // 还原
        i++;
        j--;
        // 找到了一个最大的回文子串
        if (j - i > right - left) {
            right = j;
            left = i;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("abb"));
    }
}
