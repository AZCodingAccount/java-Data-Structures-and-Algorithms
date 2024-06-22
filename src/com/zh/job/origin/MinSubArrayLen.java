package com.zh.job.origin;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-28 11:10
 * @description: 长度最小的子数组——leetcode209
 **/
public class MinSubArrayLen {

    /*
                滑动窗口，left和right指针，初始阶段left指向0，right指向1.判断 [left, right) 范围内的元素和是否大于target
            1：大于target，记录right-left的值跟min比较，尝试缩小，left++
            2：小于target，扩大滑动窗口，right++
     */
    public int minSubArrayLen(int target, int[] nums) {
        int sum = nums[0], left = 0, right = 1, min = Integer.MAX_VALUE;
        while (right <= nums.length) { // 未遍历完毕
            if (sum >= target) {
                min = Math.min(right - left, min);
                sum -= nums[left];// 维护sum变量
                left++; // 缩小窗口
            } else if (right != nums.length) {
                sum += nums[right];   // 维护sum
                right++;    // 扩大窗口
            } else {  // 最后的兜底，sum<target，可以结束
                break;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        System.out.println(new MinSubArrayLen().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
