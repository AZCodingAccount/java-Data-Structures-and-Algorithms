package com.zh.hot.matrix;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-09 17:17
 * @description: 搜索二维矩阵1—lc74
 **/
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = (m * n) - 1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) j = mid - 1;
            else if (matrix[row][col] < target) i = mid + 1;
        }
        return false;
    }
}
