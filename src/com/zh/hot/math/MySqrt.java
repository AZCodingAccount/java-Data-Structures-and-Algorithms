package com.zh.hot.math;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-05 18:55
 * @description:
 **/
public class MySqrt {
    public double mySqrt2(int x) {
        // 牛顿迭代法
        double x0 = x / 2.0, next;  // 初始值
        while (true) {
            next = (x0 + x / x0) / 2.0; // 牛顿法的公式
            if (Math.abs(next - x0) < 1e-6) {
                return next;
            }
            x0 = next;
        }
    }
    public int mySqrt(int x) {
        // 牛顿迭代法
        double x0 = x / 2.0, next;  // 初始值
        while (true) {
            next = (x0 + x / x0) / 2.0; // 牛顿法的公式
            if (Math.abs(next - x0) < 1e-6) {
                return (int)next;
            }
            x0 = next;
        }
    }

    public static void main(String[] args) {
        System.out.println(new MySqrt().mySqrt(0));
    }
}
