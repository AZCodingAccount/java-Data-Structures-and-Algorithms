package com.zh.job.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-20 10:51
 * @description: 最大子数组和—lc53
 **/
public class MaxSubArray {
    /*
         2 10 -14 5 1
            很明显使用DP，一个数只有+和不+两种状态，要求的是最大子数组的和，但是这里使用贪心试一下。
        贪心策略是当考虑到一个负数时，考虑他的前面的子数组和+现在的负数是不是负数，如果是负数，那我重新开一个子数组。
        同时遇到负数记录一下当前的最大和(为什么要记录？因为无法保证就算允许负数加进来也可能不是全局最优，并不是特别严格的贪心)

        情况很多：有全是负数、只有一个负数、负数和0，全是正数，if else就写了很多。但是是O（n）的，不知道为什么只打败了5%
     */
    public int maxSubArray(int[] nums) {
        int p = 0;      // 指针
        int res = Integer.MIN_VALUE;    // 结果，子数组最大值
        int sum = 0;    // 窗口和
        // 如果需要更多信息，比如最小子数组返回出去，就需要一个子数组记录了，这里一个sum足矣
        while (p < nums.length) {
            if (nums[p] >= 0) {  // 正数和0，无脑加即可
                if (sum < 0) {
                    sum = 0;
                }
                sum += nums[p];
                res = Math.max(res, sum);   // 快照
            } else {    // 负数，记录一下目前的最大值，并且权衡一下是不是要加进来
                if (sum == 0) {
                    sum += nums[p++];
                    continue;
                }
                res = Math.max(res, sum);   // 快照
                // 兼容全是负数的情况 -2 -1
                if ((nums[p] < 0) && (sum < nums[p])) {
                    sum = nums[p++];
                    continue;
                }
                // 正常的正数情况
                if (sum >= 0) {
                    if (sum + nums[p] < 0) {    // 小于0重开一个数组。注意这里没有包含0，实际上0无所谓的
                        sum = 0;
                    } else {
                        sum += nums[p];
                    }
                }
            }
            p++;
        }
        res = Math.max(res, sum);   // 最后来个快照
        return res;
    }

    /*

        好像不用分类讨论，发现都是需要先加然后做判断。（之前的误区是好像快照很耗费资源，实际上只要变了就做一次快照即可）
     */
    public int maxSubArray2(int[] nums) {
        int p = 0;      // 指针
        int res = Integer.MIN_VALUE;    // 结果，子数组最大值
        int sum = 0;    // 窗口和
        // 如果需要更多信息，比如最小子数组返回出去，就需要一个子数组记录了，这里一个sum足矣
        while (p < nums.length) {
            sum += nums[p++];   // 无论正负0都先加
            res = Math.max(res, sum);   // 快照
            if (sum < 0) {  // 如果当前连续和<0，那我就从下一个重新开始
                sum = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-1}));
    }
}
