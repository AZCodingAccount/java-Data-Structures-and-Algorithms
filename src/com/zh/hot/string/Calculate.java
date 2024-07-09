package com.zh.hot.string;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-09 12:01
 * @description: 计算器—lc224
 **/
public class Calculate {
    /*
        计算器三大步，1：只有+-法。2：只有+ - * / 法。3：带上小括号
     */
    int start = 0;  // 标记字符串分割

    public int calculate(String s) {
        return helper(s);
    }

    private int helper(String s) {
        LinkedList<Integer> stack = new LinkedList<>();   // 存储符号的左右数字
        char sign = '+'; // 上一次的计算符号
        int num = 0;  // 存储累计的数，跟字符串解码一样
        for (; start < s.length(); start++) {
            // 一定要缓存，如果采用递归回来++的策略，start=s.length()-1这个条件用不上，比如(1+2)
            char c = s.charAt(start);
            if (Character.isDigit(c)) num = num * 10 + (c - '0');  // 更新累计数
            if (c == '(') {
                start++;
                num = helper(s);
                // 此处不需start++，因为下一个用到的判断的c被缓存了，现在的c还是(，下次循环start更新
            }
            if ((!Character.isDigit(c) && c != ' ') || start == s.length() - 1) {
                // 比如2-1*3，碰到-再放入+2，碰到*放入-1，遍历到最后发现*再计算
                switch (sign) {
                    case '-' -> stack.push(-num);
                    case '+' -> stack.push(num);
                    case '*' -> stack.push(stack.pop() * num);
                    case '/' -> stack.push(stack.pop() / num);
                }
                sign = c;  // 更新成本次的遍历符号供下一次使用
                num = 0;    // 更新num，重新计数
            }
            // 这个一定要在计算结果的后面
            if (c == ')') {
                break;
            }
        }
        return stack.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        // System.out.println(new Calculate().calculate("3+5 / 2"));
        // System.out.println(new Calculate().calculate("3+2*2"));
        System.out.println(new Calculate().calculate("(3+2)*2"));
    }
}
