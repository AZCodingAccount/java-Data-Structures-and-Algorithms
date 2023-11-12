package com.zh.algorithm.recursive;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-10 22:06
 * @description: 斐波那契数列
 **/
public class Fibonacci {

    /*
     * 婓波那契数列是一个非常典型的问题，常见的变种有兔子问题，走台阶问题。还可以进行记忆化优化一下算法，算法的调用是指数级的，引入memory数组
     * */

    // 初始化memory数组
    private static int[] memoryArr;

    public static void initMemoryArray(int n) {
        // 数组长度初始化成n+1
        memoryArr = new int[n + 1];
        // 给数组中的元素都填充为-1
        Arrays.fill(memoryArr, -1);
        // 初始化斐波那契数列的前两项
        memoryArr[0] = 0;
        memoryArr[1] = 1;
    }

    public static int fibonacci(int n) {
       /* // 定义出口
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }*/
        // 判断当前值是否被计算过
        if (memoryArr[n] != -1) {
            return memoryArr[n];
        }
        // 如果没有被计算过，存储一份到数组中
        memoryArr[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return memoryArr[n];
    }

    @Test
    public void testFibonacci() {
        // 初始化记忆数组，当然还可以包装一下，抽成一个函数，这里就不写了，还得重命名
        initMemoryArray(4);
        assertEquals(3, fibonacci(4));
    }
}
