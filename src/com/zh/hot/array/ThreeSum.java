package com.zh.hot.array;

import java.util.*;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-03 10:51
 * @description: 三叔之和—lc15
 **/
public class ThreeSum {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int fix = -nums[i];
            HashSet<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (set.contains(fix - nums[j])) {
                    res.add(new ArrayList<>(List.of(nums[j],-fix, fix - nums[j])));
                } else {
                    set.add(nums[j]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
