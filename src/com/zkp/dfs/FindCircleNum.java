package com.zkp.dfs;

/**
 * 题547
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * <p>
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * <p>
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * <p>
 * 返回矩阵中 省份 的数量
 */
public class FindCircleNum {
    static int count = 0;
    public static void main(String[] args) {
        int[][] isConnected = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        boolean[] visit = new boolean[isConnected.length];
        for (int k = 0; k < isConnected.length; k++) {
            if (!visit[k]){
                ++count;
                dfs(isConnected, k,visit);
            }
        }
        return count;
    }

    //深度优先遍历
    public static void dfs(int[][] isConnected, int i,boolean[] visit) {
        visit[i]=true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visit[j]) {
                visit[j] = true;
                dfs(isConnected, j,visit);
            }
        }
    }

}
