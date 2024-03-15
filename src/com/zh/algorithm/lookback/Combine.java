package com.zh.algorithm.lookback;

import java.util.*;


/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-14 16:13
 * @description: 组合——leetcode77
 **/
public class Combine {
    /*
        给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
        depth=k,直接dfs即可
     */


    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> stack = new LinkedList<>(); // 临时存储访问的元素序列
        int depth = 0;      // 当前深度
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, 1, stack, res, depth, k);

        return res;
    }

    private void dfs(int n, int start, LinkedList<Integer> stack, List<List<Integer>> res, int depth, int k) {
        if (depth == k) {   // 退出条件
            res.add(new ArrayList<>(stack));
            return;
        }
        // 注意，因为不要重复，因此不需要从0开始遍历了
        for (int i = start; i <= n; i++) {
            if (k - stack.size() > (n - i + 1)) {
                continue;
            }

            stack.push(i);
            dfs(n, i + 1, stack, res, depth + 1, k);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combine().combine(4, 2));
    }
}
