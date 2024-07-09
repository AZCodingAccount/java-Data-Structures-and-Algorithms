package com.zh.hot.matrix;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-09 17:17
 * @description: 搜索二维矩阵2—lc240
 **/
public class SearchMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while (true) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] > target) i--;
            else if (matrix[i][j] < target) j++;
            if (i < 0 || j > matrix.length - 1) return false;
        }
    }
}
