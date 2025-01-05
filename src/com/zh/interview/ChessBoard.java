package com.zh.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-07 17:12
 * @description:
 **/
public class ChessBoard {
    List<EndPoint> board = new ArrayList<>(); // 棋盘状态
    // [1,2,3,]

    boolean run(EndPoint start, EndPoint end) {
        int startX = start.x;

        int startY = start.y;
        int endX = end.x;

        int endY = end.y;

        if (startX == endX) {
            int s = Math.min(startY, endY);
            int e = Math.max(startY, endY);

            for (int i = s + 1; i < e; i++) {
                int idx = (startY * 20) * startX;
                if (!board.get(idx).type.isEmpty()) {
                    return false;
                }
            }
            if (!end.type.isEmpty() && end.side != start.side) {
                return true;
            } else if (!end.type.isEmpty()) {
                return false;
            }
            return true;
        } else if (startY == endY) {
            int s = Math.min(startX, endX);
            int e = Math.max(startX, endX);
            for (int i = s + 1; i < e; i++) {
                if (!board.get(i * endY).type.isEmpty()) {
                    return false;
                }
            }
            if (!end.type.isEmpty() && end.side != start.side) {
                return true;
            } else if (!end.type.isEmpty()) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }
}
