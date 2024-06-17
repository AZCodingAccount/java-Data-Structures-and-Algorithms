package com.zh.job.stack;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-17 09:53
 * @description: 有效的括号—lc20
 **/
public class IsValid {
    /**
     * 碰到左括号入栈，碰到右括号出栈即可。注意最后栈里面还有没有剩下的元素
     **/
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            switch (ch) {
                case '(' -> stack.push(')');
                case '[' -> stack.push(']');
                case '{' -> stack.push('}');
                default -> {
                    if (!stack.isEmpty()) {
                        Character popped = stack.pop();
                        if (ch != popped) { // 不匹配
                            return false;
                        }
                    } else {    // 说明栈为空了，但是有一个需要匹配的右括号
                        return false;
                    }

                }
            }
        }
        return stack.isEmpty(); // 可能有没有处理完的
    }


    public static void main(String[] args) {
        System.out.println(new IsValid().isValid("(){}[}"));
    }
}
