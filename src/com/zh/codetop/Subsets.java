package com.zh.codetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-12-01 23:48
 * @description:
 **/
public class Subsets {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> deque = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) return res;
        backTrack(nums, 0);
        return res;
    }

    private void backTrack(int[] nums, int start) {
        res.add(new ArrayList<>(deque));

        for (int i = start; i < nums.length; i++) {
            deque.offerLast(nums[i]);
            backTrack(nums, i + 1);
            deque.pollLast();
        }
    }
}
