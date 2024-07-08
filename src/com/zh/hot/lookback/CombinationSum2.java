package com.zh.hot.lookback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-08 16:59
 * @description: 组合总和2—lc40
 **/
public class CombinationSum2 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> stack = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int[] visited = new int[candidates.length];
        dfs(visited, candidates, target, 0);
        return res;
    }

    private void dfs(int[] visited, int[] candidates, int target, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && visited[i - 1] == 0) {
                continue;
            }
            visited[i] = 1;
            stack.push(candidates[i]);
            sum += candidates[i];
            dfs(visited, candidates, target, i + 1);
            visited[i] = 0;
            stack.pop();
            sum -= candidates[i];
        }
    }
}
