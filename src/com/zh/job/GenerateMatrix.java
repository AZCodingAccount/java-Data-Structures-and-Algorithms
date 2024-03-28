package com.zh.job;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-28 17:43
 * @description: 螺旋矩阵2——leetcode59
 **/
public class GenerateMatrix {

    /*
        这个是反向生成二维螺旋矩阵，还是跟leetcode54一样，遍历变成了赋值
        注意，处理的就是不要乱，比如
        1   2   3
        4   5   6
        7   8   9
        处理的就是[a,b]都带上,1-3   6-9     8-7     4   5
        当然也可以处理[a,b)
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int num = 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                res[top][i] = num++;    // 上边
            }
            if (++top > bottom) break;
            for (int j = top; j <= bottom; j++) {
                res[j][right] = num++;    // 右边
            }
            if (--right < left) break;
            for (int i = right; i >= left; i--) {
                res[bottom][i] = num++;    // 下边
            }
            if (--bottom < top) break;
            for (int i = bottom; i >= top; i--) {
                res[i][left] = num++;    // 左边
            }
            if (++left > right) break;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new GenerateMatrix().generateMatrix(3)));
    }
}
