package com.zh.job.lookback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-29 15:24
 * @description: N皇后问题—lc51
 **/
public class SolveNQueens {
    /*
        N皇后问题回溯三部曲
    确定方法参数
        dfs一共有两个参数即可，第一个是n*n的棋盘，第二个是当前行数，棋盘甚至可以定义成全局变量压缩到一个参数
    确定收集结果
        当前行数等于棋盘数的时候才收集结果
    确定循环逻辑
        本层循环控制棋盘中的一列
     */
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] boards = new char[n][n];
        // 初始化
        for (char[] board : boards) {
            Arrays.fill(board, '.');
        }
        dfs(boards, 0);
        return res;
    }

    /**
     * 递归方法
     *
     * @param boards
     * @param row
     */
    private void dfs(char[][] boards, int row) {
        int n = boards.length;
        // 收集结果
        if (n == row) {
            List<String> list = new ArrayList<>();
            for (char[] chs : boards) {
                list.add(new String(chs));
            }
            res.add(list);
            return;
        }

        for (int i = 0; i < n; i++) {   // 主要在于从0开始
            if (isValid(i, row, boards)) {
                boards[row][i] = 'Q';
                dfs(boards, row + 1);
                boards[row][i] = '.';
            }
        }
    }

    /**
     * 判断当前位置能不能放棋子
     *
     * @param col    当前列
     * @param row    当前行
     * @param boards 棋盘
     * @return
     */
    private boolean isValid(int col, int row, char[][] boards) {
        // 为什么不需要判断同一行？因为是深度优先，每次只选取一行的一个棋子
        for (int i = 0; i < row; i++) { // 判断上面所有行
            // 判断同一列
            if (boards[i][col] == 'Q') return false;
            // 判断斜线
            // 45度
            if (col - (row - i) >= 0 && boards[i][col - (row - i)] == 'Q') return false;
            // 135度
            if (col + (row - i) < boards.length && boards[i][col + (row - i)] == 'Q') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new SolveNQueens().solveNQueens(4));
    }
}
