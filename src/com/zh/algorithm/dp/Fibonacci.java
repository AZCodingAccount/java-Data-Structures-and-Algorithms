package com.zh.algorithm.dp;


/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-10 19:42
 * @description: 斐波那契数列—DP实现
 **/
public class Fibonacci {

    public static void main(String[] args) {
        /*
            斐波那契数列递归就够用了、这里使用DP实现一下
         */
        int num = fib(6);   // 0 1 1 2 3 5 8
        System.out.println(num);
    }

    private static int fib(int n) {
        // 状态变量
        int i = 0, j = 1;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        for (int i1 = 2; i1 <= n; i1++) {
            int k = i + j; // f(n) = f(n-1)+f(n-2)
            i = j;
            j = k;
        }
        return j;

    }
}
