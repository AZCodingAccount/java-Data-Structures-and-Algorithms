package com.zh.job.lookback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-30 18:57
 * @description: 删除无效括号—lc301
 **/
public class RemoveInvalidParentheses {
    List<String> res = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        int ll = 0, rr = 0; // 代表当前字符串中多出来的左括号或右括号的个数
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') ll++;
            else if (s.charAt(i) == ')') {
                if (ll > 0) ll--;
                else rr++;
            }
        }
        backTrack(0, ll, rr, s);
        return res;
    }

    private void backTrack(int start, int ll, int rr, String s) {
        // 退出条件，能删的都删完了
        if (ll == 0 && rr == 0) {
            if (isValid(s)) res.add(s);
        }

        // 递归删除
        for (int i = start; i < s.length(); i++) {
            if (i > start && s.charAt(i) == s.charAt(i - 1)) continue;
            if (s.charAt(i) == '(' && ll > 0) { // 删除当前字符
                backTrack(i, ll - 1, rr, s.substring(0, i) + s.substring(i + 1));
            }

            if (s.charAt(i) == ')' && rr > 0) { // 删除当前字符
                // i此时相当于i+1
                backTrack(i, ll, rr - 1, s.substring(0, i) + s.substring(i + 1));
            }
        }
    }

    private boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            if (c1 == '(') stack.push(c1);
            else if (c1 == ')') {
                if (stack.isEmpty()) return false;
                Character c = stack.pop();
                if (c != '(') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses("()())()"));
    }
}
