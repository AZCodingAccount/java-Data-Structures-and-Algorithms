package com.zh.algorithm.stack;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-29 15:12
 * @description: 有效的括号—leetcode20题
 **/
public class IsValidBracket {

    public static boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        boolean flag = true;
        for (int n = 0; n < s.length(); n++) {
            switch (s.charAt(n)) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    Character c = s.charAt(n);  // 注意，这里是包装类，如果出现这种")}]("的情况，如果pop为null，就会出现空指针
                    Character pop = stack.peek();
                    if (pop == c) {
                        stack.pop();
                        break;
                    }
                    flag = false;
                    break;
            }
            if (!flag) {
                break;
            }
        }
        return stack.isEmpty() && flag;

    }

    public static void main(String[] args) {
        System.out.println(isValid("([{"));
    }
}
