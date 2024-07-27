package com.zh.job.lookback;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-27 16:04
 * @description: 最长单词—面试题17.15
 **/
public class LongestWord {
    public String longestWord(String[] words) {
        Arrays.sort(words, (o1, o2) -> {
            return o2.length() == o1.length() ? o1.charAt(0) - o2.charAt(0) : o2.length() - o1.length();
        });
        for (int i = 0; i < words.length-1; i++) {
            if (backTrack(words, words[i], i + 1)) {  // 判断当前字符串是否可以被后面的组合
                return words[i];
            }
        }
        return "";
    }

    /**
     * 判断当前字符串能不能被后面的组合
     *
     * @param words
     * @param word
     * @param start
     * @return
     */
    private boolean backTrack(String[] words, String word, int start) {
        if ("".equals(word)) {
            return true;
        }

        // 判断当前字符串是不是在子字符串的第一个位置，并且递归查找
        for (int i = start; i < words.length; i++) {
            if (word.indexOf(words[i]) == 0 && backTrack(words, word.substring(words[i].length()), start)) {
                // start不变代表可以来回循环查找，这个时候会有一个重复查找的问题，比如dogdog，可以加一个visited
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new LongestWord().longestWord(new String[]{"cat", "banana", "dog", "nana", "walk", "walker", "dogwalker"}));
    }
}
