package com.zkp.dp;

/**题64
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 */
public class MinPathSum {
    public static void main(String[] args){
       int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        MinPathSum minPathSum = new MinPathSum();
        System.out.println(minPathSum.minPathSum(grid));
    }



    public int minPathSum(int[][] grid) {
        int[][] res = new int[grid.length][grid[0].length];
        res[0][0] = grid[0][0];
        for(int i=0;i<grid.length;++i){
            for(int j = 0;j < grid[0].length;++j){
                if(i==0 && j==0) continue;
                if(i==0){
                    res[i][j] = res[i][j-1] + grid[i][j];
                }else if(j==0){
                    res[i][j] = res[i-1][j] + grid[i][j];
                }else{
                    res[i][j] = Math.min(res[i-1][j],res[i][j-1]) + grid[i][j];
                }
            }
        }
        return res[grid.length - 1][grid[0].length - 1];
    }
}
