package com.zh.algorithm.divideconquer;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-13 18:57
 * @description: 求x的n次幂—leetcode50
 **/
public class POW {
    /*
            x^10=x^5*x^5        x^5=x^2*x^2*x
     */

    public double postivePow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double pow = postivePow(x, n / 2);
        if (n % 2 == 0) {
            return pow * pow;
        } else {
            return pow * pow * x;
        }

    }

    public double myPow(double x, int n) {
        if (n < 0) {
            long k = -n;
            return 1 / postivePow(x, k);
        } else {
            return postivePow(x, n);
        }
    }

    public static void main(String[] args) {
        System.out.println(new POW().myPow(2, 5));
    }
}
