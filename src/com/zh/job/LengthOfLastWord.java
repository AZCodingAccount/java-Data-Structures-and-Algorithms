package com.zh.job;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-25 11:25
 * @description: 最后一个单词的长度——leetcode58
 **/
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        String[] split = s.split(" +");
        return split[split.length - 1].length();
    }

    public static void main(String[] args) {
        new LengthOfLastWord().lengthOfLastWord("Hello World");
        new LengthOfLastWord().lengthOfLastWord("   fly me   to   the moon  ");
    }
}
