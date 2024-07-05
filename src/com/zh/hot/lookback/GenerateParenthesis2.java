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
public class GenerateParenthesis2 {
    /*
        之前的暴力很蠢，在这个问题中，我们可以每个子问题都是要满足括号的条件的。
     */
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0);
        return res;
    }

    // left代表有多少个左括号，right代表有多少个右括号。每个子问题都满足括号的条件，当然原问题就满足括号的条件
    private void dfs(int n, int left, int right) {
        if (left == n && right == n) {
            res.add(sb.toString());
        }
        // 每次处理枚举当前位置左右括号的情况，可能出现当前位置填不了左右括号的情况
        // 先填左括号，左括号只要不超过n，就问题不大
        if (left < n) {
            sb.append("(");
            dfs(n, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        // 再填右括号，此时不仅需要右括号个数不能超过n，也要考虑右括号前面可以至少有相应个数的左括号
        if (right < n && right <= left + 1) {
            // 注意这里的判断+1，因为你如果加一个右括号，现在你的right就是left+1了，跟left不匹配
            sb.append(")");
            dfs(n, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis2().generateParenthesis(3));
    }
}
