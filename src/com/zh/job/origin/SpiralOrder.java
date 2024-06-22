package com.zh.job.origin;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-28 17:01
 * @description: 螺旋矩阵——leetcode54
 **/
public class SpiralOrder {
    /*
        这道题主要是模拟，定义4个边界，每次遍历完更新边界，遍历结束的条件是左边界超过了右边界或者上边界超过了下边界
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length; // 行和列
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        List<Integer> res = new ArrayList<>();
        while (true) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);    // 上边
            }
            if (++top > bottom) break;
            for (int j = top; j <= bottom; j++) {
                res.add(matrix[j][right]);    // 右边
            }
            if (--right < left) break;
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);    // 下边
            }
            if (--bottom < top) break;
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);    // 左边
            }
            if (++left > right) break;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SpiralOrder().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }

}
