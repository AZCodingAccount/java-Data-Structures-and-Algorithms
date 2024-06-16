package com.zh.job.str;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-16 19:26
 * @description: 重复的子字符串—lc459
 **/
public class RepeatedSubstringPattern {

    /**
     * 易知重复子串一定是从0索引开始的，直接暴力出奇迹，时间复杂度应该是n^2
     **/
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i < s.length() / 2 + 1; i++) {
            // 确定子串
            String sub = s.substring(0, i);
            int length = sub.length();  // 步长
            boolean flag = true;   // 这一轮是否能成功
            int p = 0;
            for (int j = 0; j <= s.length() - length; j += length) {
                // 确定子串有效性
                p = j;
                while (p < j + length) {
                    if (sub.charAt(p - j) != s.charAt(p)) {
                        flag = false;// 标记出现不合法的
                        break;
                    }
                    p++;
                }
            }
            if (flag && p == s.length()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 易知重复子串一定是从0索引开始的，直接暴力出奇迹
     * 使用StringBuilder和一些小细节尽量优化一下O（nlog(n)）
     **/
    public boolean repeatedSubstringPattern2(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            // 确定子串
            String sub = s.substring(0, i);
            int length = sub.length();  // 步长
            if (s.length() % length != 0) { // 剪枝
                continue;
            }
            StringBuilder sb = new StringBuilder();
            int count = 0;
            while (s.length() != count) {   // 构建新字符串
                sb.append(sub);
                count += length;
            }
            if (sb.toString().equals(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * abaaba aba
     * 移动匹配解法，就是abab然后构造一个新的字符串abababab，掐头去尾以后看字符串还在不在新的字符串中，在的话就说明有重复子字符串
     * 你问我为什么？我只能说新字符串就包含了原始字符串的所有排列，再问？好吧我是背的，把下面这句话背出来唬住面试官
     *     假如s是一个非重复字符串s，则从s的结尾任意取后缀与前缀交换顺序，都一定无法构成原字符串s。而s+s产生新的s，
     * 是由前一个s的后半部分和后一个s的前半部分拼接而成的，形式类似于s中任意取后缀与前缀交换顺序，因此不存在这样的非重复字符串s+s能生成s
     **/
    public boolean repeatedSubstringPattern3(String s) {
        // int n = s.length();
        // // 构造新字符串
        // String newStr = (s + s).substring(1, 2 * n - 1);
        // // 检查s是否在newStr中
        // return newStr.contains(s);

        // 没错就一行，从索引1开始，后面的都不用截了，如果匹配到了后面那个拼接的，说明不满足重复字符串条件
        return (s + s).indexOf(s, 1) != s.length();
    }


    public static void main(String[] args) {
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("abab"));
    }
}
