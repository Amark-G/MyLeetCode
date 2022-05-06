package com.zkp.dfs;

import java.util.ArrayList;
import java.util.List;

/**题417
 * 有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻“太平洋处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
 *
 * 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵heights，heights[r][c]表示坐标 (r, c) 上单元格 高于海平面的高度 。
 *
 * 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
 *
 * 返回网格坐标 result的 2D 列表 ，其中result[i] = [ri, ci表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可流向大西洋 。

 */
public class PacificAtlantic {
    public static void main(String[] args){
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> res = pacificAtlantic(heights);
    }
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(heights,pac,i,0,heights[i][0]);
        }
        for (int i = 0; i < n ; i++) {
            dfs(heights,pac,0,i,heights[0][i]);
        }
        for (int i = 0; i < n; i++) {
            dfs(heights,atl,m-1,i,heights[m-1][i]);
        }
        for (int i = 0; i < m; i++) {
            dfs(heights,atl,i,n-1,heights[i][n-1]);
        }
        //求二者交集
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }
    private static void dfs(int[][] heights,boolean[][] visit,int i,int j,int val){
        if (i <0 || i>= heights.length || j<0 || j>= heights[0].length || visit[i][j] || val > heights[i][j]) return;
        visit[i][j]=true;
        dfs(heights,visit,i-1,j,heights[i][j]);
        dfs(heights,visit,i+1,j,heights[i][j]);
        dfs(heights,visit,i,j-1,heights[i][j]);
        dfs(heights,visit,i,j+1,heights[i][j]);

    }

}
