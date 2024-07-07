package com.zh.hot.string;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-07 17:38
 * @description: 最长有效括号—lc32
 **/
public class LongestValidParentheses {
    /*
        栈和两次遍历的方法
     */
    // 1：栈
    public int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<>(); // 栈底存放的是有效括号开始的索引
        int maxLength = 0;
        stack.push(-1); // 代表初始化0之后的都是有效括号开始的地方
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '(') {
                stack.push(i);  // 把索引放进去，方便计算长度
            } else {  // 收集结果并判断是否需要更新有效括号开始的地方，因为只有)才会导致前功尽弃
                stack.pop();
                if (stack.isEmpty()) {    // 更新有效括号开始的地方，前面没有对应的(与其对应
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }

    // 两次遍历，就是确认之前的所有括号都满足要求，现在的就满足要求，但是有效括号长度不是固定的，因此需要往回遍历纠正一下
    public int longestValidParentheses2(String s) {
        int left = 0, right = 0;  // 左右括号个数
        int maxLength = 0;
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            if (ch == '(') left++;
            else right++;
            if (right > left) { // 之前的没用了
                left = 0;
                right = 0;
            } else if (left == right) {
                maxLength = Math.max(right + left, maxLength);
            }
        }
        left = 0;
        right = 0;
        // 从后往前扫描
        for (int i = chs.length - 1; i >= 0; i--) {
            if (chs[i] == '(') left++;
            else right++;
            if (left > right) { // 从后往前应该以right为主导
                left = 0;
                right = 0;
            } else if (left == right) {
                maxLength = Math.max(right + left, maxLength);
            }
        }

        return maxLength;
    }
}
