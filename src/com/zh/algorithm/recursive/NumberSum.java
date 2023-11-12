package com.zh.algorithm.recursive;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-11 23:19
 * @description: 计算从1加到n的值，演示爆栈
 **/
public class NumberSum {
    // 计算从1+...+n的值
    public static int sum(int n) {
        // 把n=0，n=2当成终止条件都可以
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }

    // 计算1000*1000出现爆栈。一般就需要改写算法了。
    public static void main(String[] args) {
        System.out.println(sum(1000 * 1000));
    }

}
