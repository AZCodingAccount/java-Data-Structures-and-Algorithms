package com.zh.job.lookback;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-19 10:09
 * @description: 电话号码的字母组合—lc17
 **/
public class LetterCombinations {

    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> origin = new ArrayList<>();
        // 把digits转换成List<String> 类型，当然手动映射也可以，这样更优雅一点
        StringBuilder sb = new StringBuilder();
        for (char c : digits.toCharArray()) {
            char start = (char) ('a' + ((Integer.parseInt(String.valueOf(c)) - 2) * 3));
            if (c == '8' || c == '9') {
                start = (char) (start + 1);
            }
            for (int i = 0; i < 3; i++) {
                sb.append((char) (start + i));
            }
            if (c == '9' || c == '7') {
                sb.append((char) (start + 4));
            }
            origin.add(sb.toString());
            sb.setLength(0);
        }

        dfs(origin, 0);
        return res;
    }


    /**
     * 递归方法
     *
     * @param origin 源数组
     * @param depth  目前递归深度
     */
    private void dfs(List<String> origin, int depth) {
        if (sb.length() == origin.size()) {   // 退出条件
            res.add(sb.toString());
            return;
        }

        // 主要逻辑
        String s = origin.get(depth);
        for (char c : s.toCharArray()) {
            sb.append(c);
            dfs(origin, depth + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("8"));
    }
}
