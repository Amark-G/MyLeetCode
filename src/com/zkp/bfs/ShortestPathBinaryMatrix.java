package com.zkp.bfs;

import java.security.KeyPair;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**题1091
 * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
 *
 * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
 *
 * 路径途经的所有单元格都的值都是 0 。
 * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * 畅通路径的长度 是该路径途经的单元格总数。

 */
public class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if (grid[0][0] ==1 || grid[n-1][n-1]==1) return -1;
        Queue<int[]> queue = new LinkedList<>();
        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}};
        int pathLength = 0;
        //添加起始点进入queue
        int[] start = {0,0};
        queue.add(start);
        grid[0][0] = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            ++pathLength;
            while (size-- >0){
                int[] cur = queue.poll();
                if (cur[0]==n-1 && cur[1]==n-1){
                    return pathLength;
                }
                //将可行路径入队列
                for (int i = 0; i < 8; i++) {
                    int row = cur[0] + direction[i][0];
                    if (0<=row && row <= n-1){
                        int col = cur[1] + direction[i][1];
                        if (0<=col && col <= n-1 && grid[row][col] ==0){
                            queue.add(new int[]{row, col});//可行之路
                            //将走过的路标记
                            grid[row][col] =1;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
