package com.zh.job.stack;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-17 11:28
 * @description: 逆波兰表达式求值—lc150
 **/
public class EvalRPN {

    /**
     * 使用栈，碰到一个运算符就把前两个数字取出来运算就可以了
     **/
    public int evalRPN(String[] tokens) {
        LinkedList<String> stack = new LinkedList<>();
        for (String token : tokens) {
            // 这个switch-case太简洁了！！！
            switch (token) {
                case "+", "-", "*", "/" -> {
                    String num2 = stack.pop();
                    String num1 = stack.pop();
                    switch (token) {
                        case "+" -> stack.push(String.valueOf(Integer.parseInt(num1) + Integer.parseInt(num2)));
                        case "-" -> stack.push(String.valueOf(Integer.parseInt(num1) - Integer.parseInt(num2)));
                        case "*" -> stack.push(String.valueOf(Integer.parseInt(num1) * Integer.parseInt(num2)));
                        default -> stack.push(String.valueOf(Integer.parseInt(num1) / Integer.parseInt(num2)));
                    }
                }
                default -> stack.push(token);
            }
        }
        assert stack.peek() != null;
        return Integer.parseInt(stack.peek());
    }

    public static void main(String[] args) {
        System.out.println(new EvalRPN().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }
}
