package com.zkp.dfs;

/**请设计一个函数，用来判断在一个n乘m的矩阵中是否存在一条包含某长度为len的字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 剑指offer回溯题
 * @author zkp
 * @version 1.0
 */
public class ExistPath {

    public static void main(String[] args){
        ExistPath test = new ExistPath();
        char[][] matrix = {{'a','b','c','e'},
                           {'s','f','c','s'},
                           {'a','d','e','e'}};
        System.out.println(test.hasPath(matrix,"abcced"));
    }

    boolean ret = false;
    public boolean hasPath (char[][] matrix, String word) {
        for(int i = 0; i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(ret) return true;
                boolean[][] visit = new boolean[matrix.length][matrix[0].length];
                if(matrix[i][j] == word.charAt(0)){
                    backTracking(matrix,visit,word,i,j,0);
                }
            }
        }
        return ret;
    }
    private void backTracking(char[][] matrix, boolean[][] visit, String word,
                              int row, int col, int count) {
        if (count == word.length() - 1) {
            ret = true;
            return;
        }
        if (!ret) {
            visit[row][col] = true;
            //向下
            if ((row + 1) <= matrix.length - 1  && !visit[row + 1][col] && matrix[row + 1][col] == word.charAt(count + 1)) {
                backTracking(matrix, visit, word, row + 1, col, count + 1);
                visit[row + 1][col] = false;
            }
            //向上
            if ((row - 1) >= 0  && !visit[row - 1][col] && matrix[row - 1][col] == word.charAt(count + 1)) {
                backTracking(matrix, visit, word, row - 1, col, count + 1);
                visit[row - 1][col] = false;
            }
            //向右
            if ((col + 1) <= matrix[0].length - 1  && !visit[row][col + 1] && matrix[row][col + 1] == word.charAt(count + 1)) {
                backTracking(matrix, visit, word, row, col + 1, count + 1);
                visit[row][col + 1] = false;
            }
            //向左
            if ((col - 1) >= 0  && !visit[row][col - 1] && matrix[row][col - 1] == word.charAt(count + 1)) {
                backTracking(matrix, visit, word, row, col - 1, count + 1);
                visit[row][col - 1] = false;
            }
        }
    }
}
