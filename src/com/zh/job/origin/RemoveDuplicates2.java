package com.zh.job.origin;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-19 16:11
 * @description: 删除数组重复元素2——leetcode80
 **/
public class RemoveDuplicates2 {
    /*
            这次使用快慢指针（slow代表保留元素索引，fast代表遍历元素的指针）
            0   0   0   1   1   1   2   3   3
                  slow
                  fast
          fast slow-2比较：(因为有序、并且只允许最多两个)    当前指针跟已经过滤出的数组的比较
            1：相等，说明当前元素不应该保留、fast指针往后找，找到一个不等的替换
            2：不相等，直接替换，slow和fast同时后移
     */
    public int removeDuplicates(int[] nums) {
        int fast = 2, slow = 2;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
