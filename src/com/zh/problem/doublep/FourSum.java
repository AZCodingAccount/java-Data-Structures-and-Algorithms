package com.zh.problem.doublep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-15 14:49
 * @description: 四数之和——leetcode15
 **/
public class FourSum {
    /*
               dfs [-1,0,1,2,-1,-4]
               1：当然可以三层for，但是想都不用想绝对超时
               2：之前的两数之和双指针复杂度是O(n)、现在dfs+排序时间复杂度为O(nlogn)+O(n^2)=O(n^2)


               n改成4，代码稍微改一下就可以
        */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = 4, start = 0;
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        Arrays.sort(nums);
        dfs(n, start, nums, res, stack, target);
        return res;
    }

    /**
     * @param n      当前计算几数之和
     * @param start  数组遍历的位置
     * @param nums   原始数组
     * @param res    存储结果的集合
     * @param stack  存储当前组合的时间
     * @param target 当前要计算的几数之和的值
     * @return void
     * @author AlbertZhang
     * @description 遍历数组
     * @date 2024-03-15 13:53
     **/
    private void dfs(int n, int start, int[] nums, List<List<Integer>> res, LinkedList<Integer> stack, long target) {
        if (n == 2) {
            List<List<Integer>> lists = twoSum(nums, start, target);
            lists.forEach(list -> {
                list.addAll(stack);
                res.add(new ArrayList<>(list));
            });
            return;
        }
        for (int i = start; i < nums.length; i++) {
            // 排除重复三元组，兼容   2   2   2   2   2
            if (i > start && nums[i] == nums[i - 1]) continue;
            stack.push(nums[i]);
            dfs(n - 1, i + 1, nums, res, stack, (long)target - nums[i]);
            stack.pop();
        }
    }

    /*
            返回当前sum的两个元素的值，需要注意的是，可能不止一个
     */
    public List<List<Integer>> twoSum(int[] numbers, int start, long target) {
        int left = start;
        int right = numbers.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (left < right) {
            long total = numbers[left] + numbers[right];
            if (total == target) {
                List<Integer> list = new ArrayList<>();
                list.add(numbers[left]);
                list.add(numbers[right]);
                res.add(list);
                left++;
                right--;
                /*
                    继续搜索，需要排除一个点 比如
                    -2   0   0   2   2
                        left        right
                    搜索出来了 0 2   那么如果不做处理， 又存在0  2，题目要求不能包含重复的三元组，因此判断排除一下
                */
                // 0    0   0
                while (left < numbers.length - 1 && numbers[left] == numbers[left - 1]) {
                    left++;
                }
                while (right < numbers.length - 1 && numbers[right] == numbers[right + 1]) {
                    right++;
                }
                // 此时left=right，跳出循环
            } else if (total < target) {  // 小了，移动左指针
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FourSum().fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
    }
}
