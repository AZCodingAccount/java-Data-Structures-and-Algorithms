package com.zh.job.stack;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-17 11:00
 * @description: 删除字符串中的所有相邻重复项—lc1047
 **/
public class RemoveDuplicates {

    /**
     * 使用栈即可，碰到重复的就出栈，否则入栈，但是需要注意连续出栈
     **/
    public String removeDuplicates(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        char[] chs = s.toCharArray();
        // 遍历字符串
        for (char c : chs) {
            if (!stack.isEmpty()) {
                Character peeked = stack.peek();
                if (peeked == c) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        // 拼接字符串
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicates("abbaca"));
    }
}