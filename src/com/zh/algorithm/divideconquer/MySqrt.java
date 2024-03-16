package com.zh.algorithm.divideconquer;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-14 11:19
 * @description: 计算平方根——leetcode69题
 **/
public class MySqrt {
    /*
        分治思想，证明x^2/4>=x  x>=4   x/2*x/2>=x;又因为平方根返回的是整数，因此当0<x<4时，这个式子也成立   。接着慢慢二分就可以了
            给你一个非负整数 x ，计算并返回 x 的算术平方根 。由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
        注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     */
    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        long left = 0, right = x, res = 0;
        /*
            0   1   2   3   4
            left    m       right
         */
        while (left <= right) {
            long m = (left + right) / 2;
            if (x >= m * m && x < (m + 1) * (m + 1)) {  // 找到了
                res = m;
                break;
            } else if (x > m * m) {     // 元素在右边
                left = m + 1;
            } else {    // 元素在左边
                right = m - 1;
            }
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new MySqrt().mySqrt(0));
    }


}
