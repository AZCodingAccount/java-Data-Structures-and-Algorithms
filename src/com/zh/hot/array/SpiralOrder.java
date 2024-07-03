package com.zh.hot.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-03 09:34
 * @description: 螺旋矩阵—lc54
 **/
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, right = matrix[0].length - 1, bottom = matrix.length - 1, left = 0;
        List<Integer> res = new ArrayList<>();
        while (true) {
            // 上
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            if (++top > bottom) break;
            // 右
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (--right < left) break;
            // 下
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            if (--bottom < top) break;
            // 左
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            if (++left > right) break;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SpiralOrder().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}
