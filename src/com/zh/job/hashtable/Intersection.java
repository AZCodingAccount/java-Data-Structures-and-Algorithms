package com.zh.job.hashtable;

import java.util.ArrayList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-14 19:30
 * @description: 两个数组的交集—lc349
 **/
public class Intersection {

    /**
     *
     **/
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] tempArr = new int[1001];  // 存储所有数字
        // 遍历nums1
        for (int num : nums1) {
            if (tempArr[num] == 0) {
                tempArr[num] = 1;
            }
        }
        // 遍历nums2
        for (int num : nums2) {
            if (tempArr[num] == 1) {
                tempArr[num] = 2;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 2) {
                res.add(i);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
