package com.zh.job.interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-04-10 12:16
 * @description: 汇总区间——lc228
 **/
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        int left = nums[0], right = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 == nums[i + 1]) {   // 说明属于连续的
                right = nums[i + 1];
            } else {  // 从此处断了
                if (left == right) {
                    res.add(left + "");
                } else {
                    res.add(left + "->" + right);
                }
                left = nums[i + 1];
                right = nums[i + 1];
            }
        }
        // 处理最后一组
        if (left == right) {
            res.add(left + "");
        } else {
            res.add(left + "->" + right);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SummaryRanges().summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
    }
}
