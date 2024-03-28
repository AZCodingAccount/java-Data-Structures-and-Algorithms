package com.zh.job;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-28 18:10
 * @description: 旋转图像——leetcode48
 **/
public class RotateMatrix {
    /*
        要求原地旋转，最好理解的方法就是先转置，再逐行逆序
     */

    public void rotate(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                // 转置
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 逐行逆序
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                // 转置
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = temp;
            }
        }
    }
}
