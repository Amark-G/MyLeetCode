package com.zkp.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zkp
 * @version 1.0
 *
 * 0 1 0 0 0
 * 0 1 1 1 0
 * 0 0 0 0 0
 * 0 1 1 1 0
 * 0 0 0 1 0
 *
 * (0,0)
 * (1,0)
 * (2,0)
 * (2,1)
 * (2,2)
 * (2,3)
 * (2,4)
 * (3,4)
 * (4,4)
 */
public class HJ43 {
    static boolean flag = false;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        while (sc.hasNext()){
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
        }
        List<int[]> ret = new ArrayList<>();
        backTracking(ret,matrix,0,0);
        for (int i = 0; i < ret.size(); i++) {
            int[] cur = ret.get(i);
            System.out.println("(" +cur[0] + "," + cur[1] + ")");
        }

    }
    //回溯法搜索
    private static void backTracking(List<int[]> ret,int[][] matrix,int i, int j){
        if (i == matrix.length - 1 && j == matrix[0].length - 1){
            //走到出口
            int[] temp = {i,j};
            ret.add(temp);
            flag = true;
            return;
        }
        if (!flag){
            matrix[i][j] = 1;//标记
            ret.add(new int[]{i,j});//加入该路线
            //右、下、左、上搜索走
            if (!flag && j < matrix[0].length - 1 && matrix[i][j + 1] != 1){
                //向右走
                backTracking(ret,matrix,i,j + 1);
                matrix[i][j + 1] = 0;
                if (!flag)
                    ret.remove(ret.size() - 1);
            }
            if (!flag && i < matrix.length - 1 && matrix[i + 1][j] != 1){
                //向下走
                backTracking(ret,matrix,i + 1,j);
                matrix[i + 1][j] = 0;
                if (!flag)
                    ret.remove(ret.size() - 1);
            }
            if (!flag && j > 0 && matrix[i][j - 1] != 1){
                //向左走
                backTracking(ret,matrix,i,j - 1);
                matrix[i][j - 1] = 0;
                if (!flag)
                    ret.remove(ret.size() - 1);
            }
            if (!flag && i > 0 && matrix[i - 1][j] != 1){
                //向上走
                backTracking(ret,matrix,i - 1,j);
                matrix[i - 1][j] = 0;
                if (!flag)
                    ret.remove(ret.size() - 1);
            }
        }

    }
}
