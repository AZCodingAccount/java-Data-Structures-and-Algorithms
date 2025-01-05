package com.zh.codetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-14 20:48
 * @description:
 **/
public class Permute {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> deque = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        int[] visited = new int[nums.length];
        backTrack(nums, visited);
        return res;
    }

    private void backTrack(int[] nums, int[] visited) {
        if (deque.size() == nums.length) {
            res.add(new ArrayList<>(deque));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                deque.offer(nums[i]);
                backTrack(nums, visited);
                visited[i] = 0;
                deque.pollLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permute().permute(new int[]{1, 2, 3}));
    }
}
