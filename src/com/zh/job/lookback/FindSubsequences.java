package com.zh.job.lookback;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-23 21:03
 * @description: 非递增子序列—lc491
 **/
public class FindSubsequences {
    /*
        这里不能排序，使用了每层一个set做去重逻辑，其他都是一样的，就是在判断条件和加入元素的时候做了判断
        第二种去重逻辑，但是时间和空间复杂度感人，每次递归都要维护一个set集合，深度多，对象就多。
     */
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> deque = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    /**
     * 深搜的函数
     *
     * @param nums  元素数组
     * @param start 起始索引
     */
    private void dfs(int[] nums, int start) {
        if (deque.size() >= 2) {    // 题目要求的收集条件
            res.add(new ArrayList<>(deque));
        }

        HashSet<Integer> set = new HashSet<>(); // 一定要是在函数里面，代表只管每层

        for (int i = start; i < nums.length; i++) {
            // 下面这个逻辑是当栈里面没放元素并且当前要放的元素没有遍历过
            // 或者说栈里面放元素了，但是要当前元素要大于等于之前放的元素，并且当前要放的元素本层没有遍历过。
            if (((deque.isEmpty()) || (deque.peekLast() <= nums[i])) && !set.contains(nums[i])) {
                deque.offerLast(nums[i]);
                set.add(nums[i]);
                dfs(nums, i + 1);
                deque.pollLast();    // 回溯时候不用回溯set，因为set只在本层用，上一层是一个新的set
            }
        }
    }
}
