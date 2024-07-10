package com.zh.hot.array;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-10 17:32
 * @description: 颜色分类—lc75
 **/
public class SortColors {
    public void sortColors(int[] nums) {
        int cnt0 = 0, cnt1 = 0;
        for (int num : nums) {
            if (num == 0) cnt0++;
            else if (num == 1) cnt1++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (cnt0 > 0) {
                nums[i] = 0;
                cnt0--;
                continue;
            }
            if (cnt1 > 0) {
                nums[i] = 1;
                cnt1--;
                continue;
            }
            nums[i] = 2;
        }
    }
}
