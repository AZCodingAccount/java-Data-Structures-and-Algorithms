package com.zh.hot.lookback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-05 19:42
 * @description: 括号生成—lc22
 **/
public class GenerateParenthesis {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        dfs(n);
        return res;
    }

    private void dfs(int n) {
        if (sb.length() == n * 2) {
            if (isValid()) {
                res.add(sb.toString());
            }
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (i == 0) sb.append("(");
            else sb.append(")");
            dfs(n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // 判断当前字符串是否合法
    private boolean isValid() {
        LinkedList<Character> stack = new LinkedList<>();
        char[] chs = sb.toString().toCharArray();
        for (char ch : chs) {
            if (ch == '(') {
                stack.push('(');
            } else {
                if (!stack.isEmpty()) {
                    Character popped = stack.pop();
                    if (popped != '(') return false;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(10));
    }
}
