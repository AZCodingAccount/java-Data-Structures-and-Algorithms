package com.zh.hot.stack;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-02 17:17
 * @description: 有效的括号—lc20
 **/
public class IsValid {
    /*
        经典栈
     */
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            switch (ch) {
                case ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                }
                case '}' -> {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                }
                default -> stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
