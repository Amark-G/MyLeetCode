package com.zkp.dfs;


/**题695
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 *
 * 岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设grid 的四个边缘都被 0（代表水）包围着。
 *
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 *
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。

 */
public class MaxAreaOfIsland {
    static int area=1;
    static int areaPre = 0;
    public static void main(String[] args){
       int[][] grid ={{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
       System.out.println(maxAreaOfIsland(grid));
    }
    public static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res =0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] ==1){
                    areaPre = area-1;//记录上一次的
                    //开始深搜
                    search(grid,i,j);
                    res = Math.max(area-areaPre,res);
                }
            }
        }
        res = Math.max(area-areaPre,res);
        return res;
    }
    //搜索此块陆地面积的最大值

    private static void search(int[][] grid,int i,int j){
        grid[i][j]=0;
        if ((i+1==grid.length || grid[i+1][j]==0) && (i-1<0 || grid[i-1][j]==0) && (j+1==grid[0].length || grid[i][j+1]==0) && (j-1<0 || grid[i][j-1]==0)){
            return ;
        }
        if (i-1>=0 && grid[i-1][j]==1){
            ++area;
            grid[i-1][j]=0;
             search(grid,i-1,j);
        }
        if (i+1<grid.length && grid[i+1][j]==1){
            ++area;
            grid[i+1][j]=0;
             search(grid,i+1,j);
        }
        if (j+1<grid[0].length && grid[i][j+1]==1){
            ++area;
            grid[i][j+1]=0;
             search(grid,i,j+1);
        }
        if (j-1>=0 && grid[i][j-1]==1){
            ++area;
            grid[i][j-1]=0;
             search(grid,i,j-1);
        }
    }
}
