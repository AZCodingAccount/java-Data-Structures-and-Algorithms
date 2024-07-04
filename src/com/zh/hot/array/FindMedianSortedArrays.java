package com.zh.hot.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-04 20:30
 * @description: 寻找两个正序数组的中位数—lc4
 **/
public class FindMedianSortedArrays {
    /*
        两个思路，一个是寻找第K大，一个是寻找切分点
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        int k = totalLen >> 1;
        if (totalLen % 2 == 0) { // 总和是偶数，求的是两个中间的数
            int leftNum = findKNum(nums1, nums2, k);
            int rightNum = findKNum(nums1, nums2, k + 1);
            return (leftNum + rightNum) / 2.0;
        } else {  // 总和是奇数，求的是中间那个数
            return findKNum(nums1, nums2, k + 1);
        }
    }

    /*
        寻找两个数组中第K大的数
     */
    private int findKNum(int[] nums1, int[] nums2, int k) {
        // 1：收集结果,直到找到其中一个数组删完了或者两个数组都删的只剩下一个元素
        if (nums1.length == 0) return nums2[k - 1]; // 第一个数组为空，返回第二个数组的第k个数
        if (nums2.length == 0) return nums1[k - 1];    // 同上
        if (k == 1) return Math.min(nums1[0], nums2[0]);  // 特判，防止后面索引越界

        // 2：一般情况，在两个数组中找第K大的数，不断递归查找
        int k1 = Math.min(k >> 1, nums1.length); // 分给nums1 k/2个，如果要不了就分最小值
        int k2 = Math.min(k - k1, nums2.length); // 剩下的分给nums2，分不了就分最小值

        // 为什么是k1-1?因为第k大的数是从1开始，而索引从0开始
        if (nums1[k1 - 1] < nums2[k2 - 1]) {    // 结果不可能出现在nums1左边的这个小数组中，删去并继续查找
            return findKNum(Arrays.copyOfRange(nums1, k1, nums1.length), nums2, k - k1);
        } else {  // 不可能出现在右边的这个小数组里面
            return findKNum(nums1, Arrays.copyOfRange(nums2, k2, nums2.length), k - k2);
        }
    }
}
