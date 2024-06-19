package com.zh.job.lookback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-19 09:30
 * @description: 组合总和3—lc216
 **/
public class CombinationSum3 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> stack = new LinkedList<>();
    int total = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1);
        return res;
    }

    private void dfs(int count, int sum, int start) {
        if (total == sum && stack.size() == count) { // 收集结果
            res.add(new ArrayList<>(stack));
            return;
        }
        // 3个剪枝条件，所有元素的和大于了目标值，元素的个数大于或小于目标值
        if (total > sum || stack.size() > count || stack.size() + 9 - start < count) {
            return;
        }
        // 处理结果
        for (int i = start; i <= 9; i++) {
            stack.push(i);
            total += i;
            dfs(count, sum, i + 1);
            stack.pop();
            total -= i;
        }
    }
}
