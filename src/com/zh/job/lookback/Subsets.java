package com.zh.job.lookback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-22 19:43
 * @description: 子集—lc78
 **/
public class Subsets {
    /*
        子集，感觉跟组合是一样的......
     */
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> stack = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    /**
     * 递归函数
     *
     * @param nums  原数组
     * @param start 起始索引
     */
    private void dfs(int[] nums, int start) {
        res.add(new ArrayList<>(stack));

        for (int i = start; i < nums.length; i++) {
            stack.push(nums[i]);
            dfs(nums, i + 1);
            stack.pop();
        }
    }
}
