package com.zh.hot.array;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-11 17:31
 * @description: 寻找重复数—lc287
 **/
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = left + (right - left) >>> 1;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) cnt++;
            }
            if (cnt > mid) right = mid;
            else left = mid + 1;
        }
        return left;
    }

}
