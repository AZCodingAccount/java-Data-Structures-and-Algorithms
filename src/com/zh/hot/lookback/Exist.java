package com.zh.hot.lookback;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-10 13:48
 * @description: 单词搜索
 **/
public class Exist {
    StringBuilder sb = new StringBuilder();
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    /*
        以i,j为起点，是否可以找到相应的单词。使用idx而不是StringBuilder比较，避免超时
     */
    private boolean backtrack(char[][] board, String word, int i, int j, int idx) {
        if (word.charAt(idx) != board[i][j]) return false;
        if (idx == word.length() - 1) return true;
        // 访问了当前元素
        char temp = board[i][j];
        board[i][j] = '.';
        // 向上下左右延伸
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k], ny = j + dy[k];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] != '.') {
                if (backtrack(board, word, nx, ny, idx + 1)) return true;    // 提前结束
            }
        }
        board[i][j] = temp;
        // 四面都没找到
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Exist().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }
}
