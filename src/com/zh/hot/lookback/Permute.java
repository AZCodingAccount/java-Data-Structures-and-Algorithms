package com.zh.hot.lookback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-02 19:59
 * @description: 全排列—lc46
 **/
public class Permute {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> deque = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited);
        return res;
    }

    private void backtrack(int[] nums, boolean[] visited) {
        if (deque.size() == nums.length) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                deque.offer(nums[i]);
                visited[i] = true;
                backtrack(nums, visited);
                visited[i] = false;
                deque.pollLast();
            }
        }
    }
}
