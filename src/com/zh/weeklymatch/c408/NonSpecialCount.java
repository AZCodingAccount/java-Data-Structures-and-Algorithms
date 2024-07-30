package com.zh.weeklymatch.c408;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-28 10:44
 * @description: 统计不是特殊数字的数字数量—408周赛第二题
 **/
public class NonSpecialCount {
    public int nonSpecialCount(int l, int r) {
        // 获取范围的上界的平方根
        int limit = (int) Math.sqrt(r);

        // 埃拉托斯特尼筛法找出所有素数
        boolean[] isPrime = new boolean[limit + 1];
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }
        for (int p = 2; p * p <= limit; p++) {
            if (isPrime[p]) {
                for (int multiple = p * p; multiple <= limit; multiple += p) {
                    isPrime[multiple] = false;
                }
            }
        }

        // 计算特殊数字的数量
        int specialCount = 0;
        for (int p = 2; p <= limit; p++) {
            if (isPrime[p]) {
                long squared = (long) p * p;
                if (squared >= l && squared <= r) {
                    specialCount++;
                }
            }
        }

        // 总数减去特殊数字的数量即为非特殊数字的数量
        return (r - l + 1) - specialCount;
    }

    public static void main(String[] args) {
        System.out.println(new NonSpecialCount().nonSpecialCount(4, 16));
    }
}
