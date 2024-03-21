package com.zh.problem.doublep;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-15 13:46
 * @description: 三数之和——leetcode15
 **/
public class ThreeSum {
    /*
            dfs [-1,0,1,2,-1,-4]
            1：当然可以三层for，但是想都不用想绝对超时
            2：之前的两数之和双指针复杂度是O(n)、现在dfs+排序时间复杂度为O(nlogn)+O(n^2)=O(n^2)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = 3, start = 0;
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        int sum = 0;
        Arrays.sort(nums);
        dfs(n, start, nums, res, stack, sum);
        return res;
    }

    /**
     * @param n     当前计算几数之和
     * @param start 数组遍历的位置
     * @param nums  原始数组
     * @param res   存储结果的集合
     * @param stack 存储当前组合的时间
     * @param sum   当前要计算的几数之和的值
     * @return void
     * @author AlbertZhang
     * @description 遍历数组
     * @date 2024-03-15 13:53
     **/
    private void dfs(int n, int start, int[] nums, List<List<Integer>> res, LinkedList<Integer> stack, int sum) {
        if (n == 2) {
            List<List<Integer>> lists = twoSum(nums, start, sum);
            lists.forEach(list -> {
                list.add(-sum);
                res.add(new ArrayList<>(list));
            });
            return;
        }
        for (int i = start; i < nums.length; i++) {
            // 排除重复三元组
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            stack.push(nums[i]);
            dfs(n - 1, i + 1, nums, res, stack, -nums[i]);
            stack.pop();
        }
    }

    /*
            返回当前sum的两个元素的值，需要注意的是，可能不止一个
     */
    public List<List<Integer>> twoSum(int[] numbers, int start, int target) {
        int left = start;
        int right = numbers.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (left < right) {
            int total = numbers[left] + numbers[right];
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
        System.out.println(new ThreeSum().threeSum(new int[]{0, 0, 0}));
    }
}
