package com.zh.job.lookback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-25 16:33
 * @description: 全排列2—lc47
 **/
public class PermuteUnique {

    /*
        组合问题2，常规去重
     */
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> stack = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
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
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 兼顾树层去重和树枝去重
            if ((i > 0 && visited[i - 1] == 0 && (nums[i - 1] == nums[i])) || visited[i] == 1) {
                // 第一个树层去重，第二个树枝去重
                continue;
            }
            stack.push(nums[i]);
            visited[i] = 1;
            dfs(nums, visited);
            visited[i] = 0;
            stack.pop();
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermuteUnique().permuteUnique(new int[]{1,1,2}));
    }
}
