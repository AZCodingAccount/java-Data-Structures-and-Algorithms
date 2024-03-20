package com.zh.job;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-20 09:49
 * @description: H指数——leetcode274
 **/
public class HIndex {
    /*
        记录最大的h，遍历数组对数组的每个元素都进行处理
            1：元素值小于h，直接跳过
            2：元素值大于h，验证这个元素值是否有效
        但是这个方法有个问题，h不出现在数组中
        比如10、11，这个情况h=2，但是下面的程序考虑不到，因此不以数组作为h的基数元素。
            1：首先排序
            2：接下来不确定h从哪开始，h初始值为0，直到nums[i]<h才找到h
     */

    public int hIndex2(int[] citations) {
        int h = -1;
        for (int citation : citations) {
            if (citation > h) {
                // 遍历数组，验证
                int count = 0;
                for (int i : citations) {
                    if (i >= citation) {
                        count++;
                    }
                }
                // 3   1
                // 2   20
                if (count >= citation) {
                    h = citation;
                }
            }
        }
        return h;
    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        // 1 1 3
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }

    public static void main(String[] args) {
        System.out.println(new HIndex().hIndex(new int[]{1, 3, 1}));
    }
}
