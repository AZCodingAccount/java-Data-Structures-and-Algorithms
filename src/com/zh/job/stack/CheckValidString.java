package com.zh.job.stack;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-08-01 18:27
 * @description: 有效的括号字符串—lc678
 **/
public class CheckValidString {
    public boolean checkValidString(String s) {
        LinkedList<Integer> leftStack = new LinkedList<>(); // 存储左括号索引
        LinkedList<Integer> allStack = new LinkedList<>();  // 存储*号索引
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') leftStack.push(i);
            else if (c == '*') allStack.push(i);
            else {
                if (!leftStack.isEmpty()) {
                    // 左括号栈不为空，弹出一个元素
                    leftStack.pop();
                } else if (!allStack.isEmpty()) {
                    // 通配符栈不为空（此时代表的是左括号）
                    allStack.pop();
                } else {
                    return false;   // 没有左括号匹配了
                }
            }
        }
        // 遍历完成以后看看左括号还有没有，此时通配符代表的是右括号，且索引要大于左括号
        while (!leftStack.isEmpty() && !allStack.isEmpty()) {
            Integer leftIdx = leftStack.pop();
            Integer rightIdx = allStack.pop();
            // 此时两个都是最靠后的，因此这个顺序是没毛病的
            if (rightIdx < leftIdx) return false;
        }
        return leftStack.isEmpty(); // 如果最后左括号栈还是有值，说明没有抵消完成
    }
}
