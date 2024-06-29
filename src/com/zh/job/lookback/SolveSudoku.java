package com.zh.job.lookback;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-29 16:50
 * @description: 解数独—lc37
 **/
public class SolveSudoku {
    /*
        之前是一行一行处理，这里是对每个可能的结果进行双层for循环，处理整个棋盘，注意这个逻辑即可。
     */
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(i, j, k, board)) {
                            board[i][j] = k;  // 尝试填入
                            if (solve(board)) {
                                return true;  // 继续往后查找，如果找到解就返回true
                            }
                            board[i][j] = '.';  // 如果不行，移出并回溯
                        }
                    }
                    return false;  // 如果所有数字都不行，返回false
                }
            }
        }
        return true;  // 所有位置都已正确填写，返回true
    }


    /**
     * 判断填入的数字是否合法
     *
     * @param row   行
     * @param col   列
     * @param num   寻找数字
     * @param board 棋盘
     * @return 是否合法
     */
    private boolean isValid(int row, int col, char num, char[][] board) {
        // 判断当前行是否出现过
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == num) return false;
        }
        // 判断当前列是否出现过
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num) return false;
        }
        // 判断九宫格是否出现过，计算是第几个九宫格
        int i = row / 3;    // 行
        int j = col / 3;    // 列
        for (int k = 3 * i; k < 3 * i + 3; k++) {
            for (int l = 3 * j; l < 3 * j + 3; l++) {
                if (board[k][l] == num) return false;
            }
        }
        return true;    // 都通过考验了，返回true
    }
}
