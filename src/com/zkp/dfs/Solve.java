package com.zkp.dfs;

import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.util.HashMap;
import java.util.Set;

/**
 * 题130
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 */
public class Solve {
    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solve(board);
        System.out.println("===");
    }

    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                //深搜,并且填充visit
                dfs(board, i, 0, visit);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1, visit);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i, visit);
            }
            if (board[m - 1][i] == 'O') {
                dfs(board, m - 1, i, visit);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && board[i][j] == 'O') {
                    //深搜改值
                    board[i][j]='X';
                }
            }
        }
    }


    public static void dfs(char[][] board, int i, int j, boolean[][] visit) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visit[i][j] || board[i][j] == 'X') return;
        visit[i][j] = true;
        dfs(board, i, j - 1, visit);
        dfs(board, i, j + 1, visit);
        dfs(board, i - 1, j, visit);
        dfs(board, i + 1, j, visit);
    }

}
