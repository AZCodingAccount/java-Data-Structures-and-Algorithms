package com.zh.hot.string;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-08 19:19
 * @description: 字符串解码—lc394
 **/
public class DecodeString {
    /*
        字符串解码使用一个res维护当前的字符串，两个栈一个存放上一个字符串、一个存放当前字符串的重复次数
    这样的好处是不用考虑2[aa]2[b]和2[a3[b]]的区别了，每次遇到右括号就收集结果，遇到左括号就存放结果
     */
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        LinkedList<String> charStack = new LinkedList<>();
        LinkedList<Integer> multiStack = new LinkedList<>();
        int multi = 0;

        char[] chs = s.toCharArray();
        for (char ch : chs) {
            if (Character.isDigit(ch)) multi = 10 * multi + ch - '0'; // 数字
            else if (ch == '[') {
                multiStack.push(multi); // 乘数放进去
                charStack.push(res.toString()); // 之前的res放进去，方便后面做拼接
                multi = 0;    // 更新乘数，方便下一轮计算
                res = new StringBuilder();
            } else if (Character.isLetter(ch)) {    // 字母
                res.append(ch);
            } else {  // ]，收集结果
                Integer mul = multiStack.pop();
                String s1 = String.valueOf(res).repeat(Math.max(0, mul)); // res存储的是上一个完整字符串的值
                res = new StringBuilder(charStack.pop() + s1); // 更新最新的res值
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a]2[bc]"));
    }
}
