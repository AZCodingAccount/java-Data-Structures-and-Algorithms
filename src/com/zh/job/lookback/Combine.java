package com.zh.job.lookback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-18 21:17
 * @description: 组合问题—lc77
 **/
public class Combine {
    /*
        模版题，背下来都行。回溯的三个步骤，收集结果，处理结果，回溯
     */
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> stack = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);
        return res;
    }

    /**
     * 回溯的工具方法
     *
     * @param n     遍历范围
     * @param k     结果大小
     * @param start 开始索引
     */
    private void dfs(int n, int k, int start) {
        if (stack.size() == k) {    // 收集结果
            res.add(new ArrayList<>(stack));
            return;
        }

        // 业务处理
        for (int i = start; i <= n; i++) {
            stack.push(i);
            // 进入下一层
            if (stack.size() + n - i >= k) {    // 剪枝，如果剩下的元素够了再去遍历
                dfs(n, k, i + 1);
            }
            stack.pop();    // 回溯
        }
    }
}
