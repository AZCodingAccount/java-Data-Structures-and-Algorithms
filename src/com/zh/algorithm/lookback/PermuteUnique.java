package com.zh.algorithm.lookback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-14 15:09
 * @description: 全排列问题——leetcode47
 **/
public class PermuteUnique {
    /*
            给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
            输入：nums = [1,1,2]
            输出：
            [[1,1,2],
             [1,2,1],
             [2,1,1]]
            典型的回溯，但是需要注意去重的问题，此外，如何实现回溯也是一个问题
            1：不停地改变数组，每次遍历过了就新增元素或者删除元素
            2：定义一个访问数组，标记当前访问的元素
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        LinkedList<Integer> stack = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, visited, stack, result);
        return result;
    }

    /**
     * @param nums    原数组
     * @param visited 记录访问元素的数组
     * @param stack   临时存放本次遍历的元素
     * @return void
     * @author AlbertZhang
     * @description dfs遍历
     * @date 2024-03-14 15:46
     **/
    public static void dfs(int[] nums, boolean[] visited, LinkedList<Integer> stack, List<List<Integer>> res) {
        // 当栈里面放满了元素的时候，就代表本次遍历完成——递归出口
        if (stack.size() == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 去重,i>0特殊条件、第二个条件判断相等、第三个条件标记上一个元素正在访问，就不要重复访问了
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {    // 说明当前元素没有访问
                stack.push(nums[i]);
                visited[i] = true;
                dfs(nums, visited, stack, res);
                // 恢复原来的状态
                visited[i] = false;
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new PermuteUnique().permuteUnique(new int[]{1, 1, 2});
        System.out.println(lists);
    }
}
