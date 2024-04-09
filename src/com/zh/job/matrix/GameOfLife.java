package com.zh.job.matrix;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-04-09 09:32
 * @description: 生命游戏——lc289
 **/
public class GameOfLife {
    /*
            一个简单的方法是创建一个新的二维数组。首先处理边界条件，然后处理中间的部分
     */

    public void gameOfLife(int[][] board) {
        // 3行2列
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < newBoard.length; i++) {
            System.arraycopy(board[i], 0, newBoard[i], 0, newBoard[0].length);
        }

        for (int i = 0; i < newBoard.length; i++) {
            for (int j = 0; j < newBoard[i].length; j++) {
                // 第i行第j列
                int size = 0;
                for (int k = -1; k <= 1; k++) { // y轴偏移量
                    for (int l = -1; l <= 1; l++) { // x轴偏移量
                        if ((k != 0 || l != 0) && i + k >= 0 && j + l >= 0 && i + k < newBoard.length && j + l < newBoard[0].length) {
                            if (newBoard[i + k][j + l] == 1) { // 活细胞
                                size++;
                            }
                        }
                    }
                }
                // 如果当前位置是活细胞
                if (newBoard[i][j] == 1 && (size < 2 || size > 3)) {
                    board[i][j] = 0;
                } else if (newBoard[i][j] == 0 && size == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        new GameOfLife().gameOfLife(new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}});
    }
}
