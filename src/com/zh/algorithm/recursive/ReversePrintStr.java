package com.zh.algorithm.recursive;

import org.junit.jupiter.api.Test;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-07 21:14
 * @description: 反向打印字符串
 **/
public class ReversePrintStr {
    private final static String PRINT_STRING = "abcd";

    public void reversePrintStr(int n) {
        if (n >= PRINT_STRING.length()) {
            return;
        }
        reversePrintStr(n + 1);
        // 也可以把打印放在上面，那就是需要从字符串长度-1开始了，其实意义也不大了，主要是递 归
        System.out.println(PRINT_STRING.charAt(n));
    }

    @Test
    public void testReversePrintStr() {
        reversePrintStr(0);
    }
}
