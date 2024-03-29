package com.zh.job.matrix;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-29 14:56
 * @description: 矩阵置0——leetcode73
 **/
public class SetZeroes {

    /*
            定义一个pair存储0的位置，再一次遍历直接赋为0即可，java使用map
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] pair = new int[m][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) pair[i][j] = 1;  // 第3行第2列
            }
        }

        for (int i = 0; i < pair.length; i++) {
            for (int j = 0; j < pair[i].length; j++) {
                if(pair[i][j]==1){
                    // 原地修改
                    for (int k = 0; k < matrix[0].length; k++) {    // 修改行
                        matrix[i][k] = 0;
                    }
                    for (int k = 0; k < matrix.length; k++) {    // 修改列
                        matrix[k][j] = 0;
                    }
                }
            }
        }
    }
}
