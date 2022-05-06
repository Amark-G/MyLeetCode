package com.zkp.dfs;

/**
 * 题79
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class Exist {

    static boolean flag;
    static boolean[][] visited;

    public static void main(String[] args) {
        char[][] board = {{'a'},{'a'},{'a'}};
        String word = "aaaa";
        System.out.println(exist(board,word));
    }
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                visited = new boolean[board.length][board[0].length];
                backTracking(board, i, j, 0, word);
                if (flag) return true;
            }
        }
        return flag;
    }

    private static void backTracking(char[][] board, int i, int j, int count, String word) {
        if (board[i][j] != word.charAt(count)) {
            return;
        }
        if (count == word.length() - 1) {
            flag = true;
            return;
        }
        visited[i][j] = true;
        //开始回溯的搜索下一个字符
        if (i - 1 >= 0 && !visited[i - 1][j]) {
            backTracking(board, i - 1, j, count + 1, word);
            visited[i - 1][j] = false;
        }
        if (i + 1 < board.length && !visited[i + 1][j]) {
            backTracking(board, i + 1, j, count + 1, word);
            visited[i + 1][j] = false;
        }
        if (j - 1 >= 0 && !visited[i][j - 1]) {
            backTracking(board, i, j - 1, count + 1, word);
            visited[i][j - 1] = false;
        }
        if (j + 1 < board[0].length && !visited[i][j + 1]) {
            backTracking(board, i, j + 1, count + 1, word);
            visited[i][j + 1] = false;
        }
    }
}
