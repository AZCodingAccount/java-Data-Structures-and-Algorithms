package com.zh.job.lookback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-22 19:55
 * @description: 子集加上去重的逻辑—lc90
 **/
public class SubsetsWithDup {
    /*
        模版题，先排序，使用visited数组标记重复
     */
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> stack = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        dfs(nums, 0, visited);
        return res;
    }

    /**
     * dfs函数
     *
     * @param nums    原始数据
     * @param start   起始索引
     * @param visited 存储访问过的数组
     */
    private void dfs(int[] nums, int start, int[] visited) {
        res.add(new ArrayList<>(stack));

        for (int i = start; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] && visited[i] == 0) {
                continue;
            }
            stack.push(nums[i]);
            visited[i] = 1;
            dfs(nums, i + 1, visited);
            stack.pop();
            visited[i] = 0;
        }
    }
}
