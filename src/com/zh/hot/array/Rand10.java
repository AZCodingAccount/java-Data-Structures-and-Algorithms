package com.zh.hot.array;

import java.util.Random;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-12 13:16
 * @description: 用Rand7实现Rand10
 **/
public class Rand10 {
    // [0,6] * 7= [0,7,14,21,28,35,42] +[0,6]=随机生成[0,48]这些数字，要随机生成[0,10],只需要<=40的对10求余就可以了
    public int rand10() {
        int num = getNum();   // num是从[0,48]的
        while (num >= 40) {
            num = getNum();
        }
        return (num % 10) + 1;
    }

    private int getNum() {
        return (rand7() - 1) * 7 + (rand7() - 1);
    }

    // 生成[1,7]的随机索引
    private int rand7() {
        return (int) (Math.random() * (7 - 1 + 1)) + 1;
    }
}
