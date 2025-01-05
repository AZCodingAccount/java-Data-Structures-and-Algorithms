package com.zh.codetop;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-07 00:01
 * @description: 有效的括号
 **/
public class IsValid {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            switch (c) {
                case ')' -> {
                    if (!stack.isEmpty()) {
                        Character popped = stack.pop();
                        if (popped != '(') {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                case ']' -> {
                    if (!stack.isEmpty()) {
                        Character popped = stack.pop();
                        if (popped != '[') {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                case '}' -> {
                    if (!stack.isEmpty()) {
                        Character popped = stack.pop();
                        if (popped != '{') {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                default -> stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
