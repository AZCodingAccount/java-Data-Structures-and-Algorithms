package com.zh.exam;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-29 13:31
 * @description: 简单计算器
 **/
public class Widget {
    // 支持加减乘除
    public int widget(String s) {
        LinkedList<Character> stack1 = new LinkedList<>();  // 存储运算符
        LinkedList<Integer> stack2 = new LinkedList<>();    // 存储数字
        // 先把第一个数存进去
        int num = 0, j = 0;
        while (Character.isDigit(s.charAt(j))) {
            num = num * 10 + (s.charAt(j++) - '0');
        }
        stack2.push(num);
        // 第一轮循环先把数字加进去并且处理* /
        for (int i = j; i < s.length(); ) {
            char c = s.charAt(i);
            int num1 = 0;
            if (!Character.isDigit(c)) {    // 跳过运算符
                stack1.push(c);
                i++;
                continue;
            } else {  // 可能存在24这种情况，统计一下大于10的数字
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num1 = num1 * 10 + (s.charAt(i++) - '0');
                }
            }
            if (stack1.isEmpty()) continue;
            Character c2 = stack1.peek();    // 此时c2一定是运算符，c一定是数字
            switch (c2) {
                case '*' -> {
                    stack1.pop();
                    Integer num2 = stack2.pop();
                    stack2.push(num2 * num1);
                }
                case '/' -> {
                    stack1.pop();
                    Integer num2 = stack2.pop();
                    stack2.push(num2 / num1);
                }
                case '+' -> {
                    stack2.push(num1);
                }
                case '-' -> {
                    stack2.push(-num1);
                }
            }
        }
        // 第二轮处理+-
        while (!stack1.isEmpty()) {
            Character c = stack1.pop();
            switch (c) {
                case '+', '-' -> {
                    Integer num1 = stack2.pop();
                    Integer num2 = stack2.pop();
                    stack2.push(num2 + num1);
                }
            }
        }
        return stack2.peek();
    }


    // 仅支持加减
    public int widget2(String s) {
        LinkedList<Character> stack1 = new LinkedList<>();  // 存储运算符
        LinkedList<Integer> stack2 = new LinkedList<>();    // 存储数字
        int num = 0, j = 0;
        while (Character.isDigit(s.charAt(j))) {
            num = num * 10 + (s.charAt(j++) - '0');
        }
        stack2.push(num);
        // 第一轮循环先把数字加进去并且处理* /
        for (int i = j; i < s.length(); ) {
            char c = s.charAt(i);
            int num1 = 0;
            if (!Character.isDigit(c)) {    // 跳过运算符
                stack1.push(c);
                i++;
                continue;
            } else {  // 可能存在24这种情况，跳过一下
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num1 = num1 * 10 + (s.charAt(i++) - '0');
                }
            }
            if (stack1.isEmpty()) continue;
            Character c2 = stack1.peek();    // 此时c2一定是运算符，c一定是数字
            switch (c2) {
                case '+' -> {
                    stack1.pop();
                    Integer num2 = stack2.pop();
                    stack2.push(num2 + num1);
                }
                case '-' -> {
                    stack1.pop();
                    Integer num2 = stack2.pop();
                    stack2.push(num2 - num1);
                }
            }
        }
        return stack2.peek();
    }

    public static void main(String[] args) {
        System.out.println(new Widget().widget("1+2+3-4*2"));   // -2
        System.out.println(new Widget().widget("1+2+3-4/2"));   // 4
        System.out.println(new Widget().widget("2*3*4"));   // 24
        System.out.println(new Widget().widget("24/3/4"));   // 2
        System.out.println(new Widget().widget("24-2-1"));   // 21
        System.out.println(new Widget().widget("2-20-10"));   // 21
    }
}
