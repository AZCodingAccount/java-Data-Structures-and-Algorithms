package com.zh.job.hashtable;

import java.util.HashMap;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-29 20:38
 * @description: 单词规律——leetcode290
 **/
public class WordPattern {

    /*
                解题方法是定义一个数组，长度为128，存储pattern对应的英文单词
            如果遍历着发现数组元素不重复了，就说明不符合条件
            测试用例有一个 abba dog dog dog dog
            这样使用数组判断是过不了的，这次需要在添加赋值之前判断一下是否这个键没有但是已经存储这个值了
     */
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" +");
        char[] patterns = pattern.toCharArray();
        if (pattern.length() != strings.length) return false;
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (map.get(patterns[i]) == null) {
                if (map.containsValue(strings[i])) {
                    return false;
                }
                map.put(patterns[i], strings[i]);
            } else {  // 判断存储的是否相等
                if (!map.get(patterns[i]).equals(strings[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new WordPattern().wordPattern("abba", "dog cat cat dog"));
    }
}
