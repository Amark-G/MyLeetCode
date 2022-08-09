package com.zkp.dp;

/**
 * @author zkp
 * @version 1.0
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */
public class MaximalSquare {
    public int maxSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxEdge = 0;
        int[][] dp = new int[m][n];//dp[i][j] 表示以位置{i,j}为正方形右下角的最大正方形长度
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = matrix[i][j] - '0';
                else if (matrix[i][j] == '0')
                    dp[i][j] = 0;
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1],Math.min(dp[i][j - 1],dp[i - 1][j])) + 1;
                maxEdge = Math.max(maxEdge,dp[i][j]);
            }
        }
        return maxEdge * maxEdge;
    }
}
