package com.zh.weeklymatch.c408;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-28 11:36
 * @description: 判断矩形的两个角落是否可达第4题
 **/
public class CanReachCorner {
    public boolean canReachCorner(int X, int Y, int[][] circles) {
        boolean[][] visited = new boolean[X + 1][Y + 1];
        boolean[][] blocked = new boolean[X + 1][Y + 1];

        // 初始化阻塞点
        for (int i = 0; i <= X; i++) {
            for (int j = 0; j <= Y; j++) {
                for (int[] circle : circles) {
                    if (isInsideCircle(i, j, circle)) {
                        blocked[i][j] = true;
                        break;
                    }
                }
            }
        }

        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(0, 0));
        visited[0][0] = true;

        int[][] directions = {{1, 0}, {0, 1}, {1, 1}};

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (current.x == X && current.y == Y) {
                return true;
            }

            for (int[] dir : directions) {
                int nx = current.x + dir[0];
                int ny = current.y + dir[1];
                if (nx >= 0 && nx <= X && ny >= 0 && ny <= Y && !visited[nx][ny] && !blocked[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                }
            }
        }

        return false;
    }
    private  boolean isInsideCircle(int x, int y, int[] circle) {
        int xi = circle[0], yi = circle[1], ri = circle[2];
        return (x - xi) * (x - xi) + (y - yi) * (y - yi) <= ri * ri;
    }

}
