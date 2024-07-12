package com.zh.hot.array;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-12 19:39
 * @description: 寻找峰值—lc162
 **/
public class FindPeakElement {
    /*
        注意题目中有一个条件，nums[-1]和nums[n]=父无穷
     */
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // 检查是否是第一个元素并且它大于第二个元素
            if (mid == 0 && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            // 检查是否是最后一个元素并且它大于倒数第二个元素
            if (mid == nums.length - 1 && nums[mid] > nums[mid - 1]) {
                return mid;
            }
            // 检查是否是峰值元素
            if (mid > 0 && mid < nums.length - 1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            // 更新左右指针
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new FindPeakElement().findPeakElement(new int[]{1, 2}));
    }
}
