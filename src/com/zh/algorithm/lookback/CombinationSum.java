package com.zh.algorithm.lookback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-14 17:05
 * @description: 组合总和——leetcode39
 **/
public class CombinationSum {
    /*
            给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
        candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
        对于给定的输入，保证和为 target 的不同组合数少于 150 个。

        只要求组合，列举值的一般都是回溯遍历。退出条件是stack里面的值+起来大于等于target
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> stack = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, stack, res, candidates, target, 0);
        return res;
    }

    private void dfs(int start, LinkedList<Integer> stack, List<List<Integer>> res, int[] candidates, int target, int sum) {
        if (sum >= target) {    // 找到了
            if (sum == target) {
                res.add(new ArrayList<>(stack));
            }
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            stack.push(candidates[i]);
            dfs(i, stack, res, candidates, target, sum + candidates[i]);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
