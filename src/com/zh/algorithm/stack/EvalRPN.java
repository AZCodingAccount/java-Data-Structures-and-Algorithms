package com.zh.algorithm.stack;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Stack;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-29 15:39
 * @description: 逆波兰表达式求值, leetcode150题
 **/
public class EvalRPN {
    public static int evalRPN(String[] tokens) {
        LinkedList<String> stack = new LinkedList<>();
        int res = 0;

        for (String token : tokens) {
            if (Objects.equals(token, "+")) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                int littleRes = a + b;
                stack.push(String.valueOf(littleRes));
            } else if (Objects.equals(token, "-")) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                int littleRes = a - b;
                stack.push(String.valueOf(littleRes));
            } else if (Objects.equals(token, "*")) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                int littleRes = a * b;
                stack.push(String.valueOf(littleRes));
            } else if (Objects.equals(token, "/")) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                int littleRes = a / b;
                stack.push(String.valueOf(littleRes));
            } else {
                stack.push(token);
            }
        }
        if (stack.peek() != null) {
            return Integer.parseInt(stack.peek());
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] tokens=new String[]{"2","1","+","3","*"};
        int res = evalRPN(tokens);
        System.out.println(res);
    }
}
