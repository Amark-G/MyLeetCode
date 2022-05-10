package com.zkp.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题37
 * 编写一个程序，通过填充空格来解决数独问题。
 * <p>
 * 数独的解法需 遵循如下规则：
 * <p>
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。
 * 数独部分空格内已填入了数字，空白格用'.'表示。
 */
public class SolveSudoku {
    boolean flag = false;
    private final List<int[]> spaces = new ArrayList<>();
    public static void main(String[] args) {
        SolveSudoku solveSudoku = new SolveSudoku();
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        char[][] ans = {{'5','3','4','6','7','8','9','1','2'},
                        {'6','7','2','1','9','5','3','4','8'},
                        {'1','9','8','3','4','2','5','6','7'},
                        {'8','5','9','7','6','1','4','2','3'},
                        {'4','2','6','8','5','3','7','9','1'},
                        {'7','1','3','9','2','4','8','5','6'},
                        {'9','6','1','5','3','7','2','8','4'},
                        {'2','8','7','4','1','9','6','3','5'},
                        {'3','4','5','2','8','6','1','7','9'}};
    }

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                }
            }
        }
        backTracking(board,0);
    }

    private void backTracking(char[][] board, int pos) {
        if (pos == spaces.size()) {
            flag = true;
            return;
        }
        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        for (int k = 1; k <= 9 && !flag; k++) {
            board[i][j] = (char) (k + '0');
            if (judge(board, i, j)) {
                backTracking(board,pos + 1);
            }
        }

    }

    private boolean judge(char[][] board, int i, int j) {
        //判断位置i，j填充的数字是否合法
        //行判断
        for (int col = 0; col < board[0].length; col++) {
            if (col != j) {
                if (board[i][col] == board[i][j]) return false;
            }
        }
        //列判断
        for (int row = 0; row < board.length; row++) {
            if (row != i) {
                if (board[row][j] == board[i][j]) return false;
            }
        }
        //九宫格判断
        int rowBegin = 3 * (i / 3);
        int colBegin = 3 * (j / 3);
        for (int k = rowBegin; k < rowBegin + 3; k++) {
            for (int l = colBegin; l < colBegin + 3; l++) {
                if (k != i && l != j) {
                    if (board[k][l] == board[i][j]) return false;
                }
            }
        }
        return true;
    }
}
