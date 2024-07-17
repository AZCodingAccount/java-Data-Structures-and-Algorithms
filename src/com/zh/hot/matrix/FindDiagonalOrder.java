package com.zh.hot.matrix;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-17 11:56
 * @description: 对角线遍历—lc498
 **/
public class FindDiagonalOrder {
    // 模拟走的方向
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        int idx = 0;    // 数组索引
        int[] dx = new int[]{-1, 0, 1, 1}, dy = new int[]{1, 1, -1, 0};        // 右上、右、左下、下
        int x = 0, y = 0, d = 0;
        boolean[][] visited = new boolean[m][n];   // 记录某个矩形节点是否访问过
        for (int i = 0; i < m * n; i++) {
            res[idx++] = mat[x][y]; // 加入结果集中
            visited[x][y] = true;
            if (i == m * n - 1) continue;  // 最后一个遍历完毕以后直接退出，避免死循环，因为四个方向都走不了了
            int a = x + dx[d], b = y + dy[d];
            // 不停向下寻找，直到找到一个正常的
            while (a < 0 || a >= m || b < 0 || b >= n || visited[a][b]) {
                d = (d + 1) % 4;
                a = x + dx[d];
                b = y + dy[d];
            }
            // 先移动完这一步
            x = x + dx[d];
            y = y + dy[d];
            // 纠正移动方向
            if (d == 1 || d == 3) d = (d + 1) % 4;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindDiagonalOrder().findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }
}
