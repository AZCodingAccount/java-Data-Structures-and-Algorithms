package com.zh.algorithm.recursive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-07 21:02
 * @description: 阶乘的实现
 **/
public class Fac {
    // 定义一个递归函数
    public int fac(int n) {
        // 正常是递归到1，如果传入0的话也可以计算
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * fac(n - 1);
    }

    @Test
    public void testFac() {
        int sum = fac(5);
        assertEquals(120, sum, "阶乘计算错误");
        assertEquals(1, fac(0), "阶乘计算错误");
    }
}
