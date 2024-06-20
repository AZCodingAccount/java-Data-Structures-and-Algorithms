package com.zh.job.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-20 17:48
 * @description: K次取反后最大化的数组和—lc1005
 **/
public class LargestSumAfterKNegations {
    /*
        解法1：从小到大排完序以后从数组最左边开始反转，反转的同时相加
        1：碰到0结束，继续遍历
        2：没有碰到0碰到了正数，
        判断剩下的k是奇数还是偶数，k是偶数，继续遍历相加，k是奇数,Math.min(Math.abs(nums[i-1]),Math.abs(nums[i]))
        3：k不够用了，继续遍历

        解法2：上面是非常麻烦的操作，要写很多if else，实际上按照绝对值排序最好，这样就不用关心所谓的0了。
        解法3：两次排序，Java使用这个最方便，因为还得转换成包装类，然后再自定义比较器，见仁见智吧，实际上使用内置函数也没慢多少
     */

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
            res += nums[i];
        }
        Arrays.sort(nums);
        if (k % 2 != 0) {
            res -= 2 * nums[0];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LargestSumAfterKNegations().largestSumAfterKNegations(new int[]{-4, -2, -3}, 4));
    }
}
