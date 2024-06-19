package com.zh.job.lookback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-19 12:18
 * @description: 组合总和—lc39
 **/
public class CombinationSum {
    /*
        跟组合数一样的，就是终止条件和start需要注意一下，都是板子题
     */
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> stack = new LinkedList<>();

    int sum = 0;    // 当前路径的总和

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return res;
    }

    /**
     * 递归函数
     *
     * @param candidates 可以用来选择的数组
     * @param target     目标值—终止条件
     * @param start      当前开始遍历值的索引，避免重复遍历
     */
    private void dfs(int[] candidates, int target, int start) {
        if (sum >= target) { // 终止条件
            if (sum == target) {    // 收集结果
                res.add(new ArrayList<>(stack));    // 一定拷贝
            }
            return; // 这个return是一定要的，不然会死循环，比如target=9，然后一直 +2、+2
        }
        // 业务处理
        for (int i = start; i < candidates.length; i++) {
            stack.push(candidates[i]);
            sum += candidates[i];
            dfs(candidates, target, i);
            sum -= candidates[i];
            stack.pop();
        }
    }
}
