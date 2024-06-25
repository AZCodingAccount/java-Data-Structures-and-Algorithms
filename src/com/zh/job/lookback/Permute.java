package com.zh.job.lookback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-25 16:23
 * @description: 全排列—lc46
 **/
public class Permute {
    /*
        跟组合问题的区别是在树底部搜集结果，并且要使用一个visited数组避免同一颗子树上重复访问，以前限制结果使用的是一个startIIndex
     */
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> stack = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        int[] visited = new int[nums.length];
        dfs(nums, visited);
        return res;
    }

    /**
     * 递归方法
     *
     * @param nums    原始数组
     * @param visited 辅助数组
     */
    private void dfs(int[] nums, int[] visited) {
        if (stack.size() == nums.length) {
            res.add(new ArrayList<>(stack));
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 0) {  // 当前元素没有被访问过
                stack.push(nums[i]);
                visited[i] = 1;
                dfs(nums, visited);
                visited[i] = 0;
                stack.pop();
            }
        }
    }
}
