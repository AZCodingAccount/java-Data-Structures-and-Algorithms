package com.zh.job.lookback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-19 20:56
 * @description: 组合总和2—（去重逻辑）—lc82
 **/
public class CombinationSum2 {
    /*
        组合总和2包含了去重逻辑，carl哥说的横向去重，新的板子有没有！
        理解去重是横向，不需要深度遍历时候就可以了！
     */

    // 前面两个是板子，sum是求和必须写的
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> stack = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);    // 必须排序，不然没办法判断重复，跟三数之和的去重逻辑一样
        int[] visited = new int[candidates.length];
        dfs(candidates, target, 0, visited);
        return res;
    }

    /**
     * 递归方法
     *
     * @param candidates 原始数组
     * @param target     相加的目标值
     * @param start      开始索引
     * @param visited    存储访问过的数组，帮助去重
     */
    private void dfs(int[] candidates, int target, int start, int[] visited) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(stack));
        }
        for (int i = start; i < candidates.length; i++) {
            // 去重逻辑
            if (i > 0 && candidates[i] == candidates[i - 1] && visited[i - 1] == 0) {   // 这个==0代表排除掉dfs，找横向的
                continue;
            }
            stack.push(candidates[i]);
            sum += candidates[i];
            visited[i] = 1;
            dfs(candidates, target, i + 1, visited);
            stack.pop();
            sum -= candidates[i];
            visited[i] = 0;
        }
    }
}
