package com.zh.algorithm.hashtable;

import java.util.*;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-06 09:08
 * @description: 最常见的单词—leetcode819
 **/
public class MostCommonWord {
    /*
            解题思路：
                1：判断每个字符是不是属于英文字符，是的话拼接到单词字符串中，不是的话将之前的单词添加到哈希表中。注意处理最后一个单词
                2：再遍历单词数组，键为单词，值为出现的次数，
                3：移除禁用词，
                4：一次遍历即可求出最常见的字符
     */

    public String mostCommonWord(String paragraph, String[] banned) {
        StringBuilder wordSb = new StringBuilder();    // 单词
        HashMap<String, Integer> wordsFrequency = new HashMap<>();  // 存储单词出现频率的数组
        String maxLengthStr = "";
        int maxLength = 0;
        for (char c : paragraph.toCharArray()) {
            // 1：如果是单词
            if (Character.isLetter(c)) {
                wordSb.append(Character.toLowerCase(c));   // 转换成小写
            } else {
                if (wordSb.isEmpty()) {
                    // 1：第二次统计单词
                    continue;
                }
                String wordStr = wordSb.toString();
                // 2；其他字符，对单词进行处理
                wordsFrequency.put(wordStr, wordsFrequency.getOrDefault(wordStr, 0) + 1);
                // 1：更新完哈希表后重置wordSb
                wordSb.setLength(0);
            }
        }
        // 1：处理最后一个单词
        if (!wordSb.isEmpty()) {
            wordsFrequency.put(wordSb.toString(), wordsFrequency.getOrDefault(wordSb.toString(), 0) + 1);
        }

        // 3：移除禁用词，把数组转换成set效率高一点，不用每次判断都遍历
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        // 4：寻找最常见的字符
        for (Map.Entry<String, Integer> entry : wordsFrequency.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (!bannedSet.contains(key) && value > maxLength) {
                maxLength = value;
                maxLengthStr = key;
            }
        }
        return maxLengthStr;
    }

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = new String[]{"hit"};
        System.out.println(new MostCommonWord().mostCommonWord(paragraph, banned));
    }
}
