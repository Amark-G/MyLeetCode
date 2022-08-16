package com.zkp.huawei;

import java.util.Scanner;

/**
 * @author zkp
 * @version 1.0
 */
public class HJ35 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int row = 1;
        int preRow = 1;
        while (row <= n){
            int col = 2;
            int preCol = preRow;
            int dRow = row - 1;//第i行第一个数与第i - 1行第一个数差值
            int dCol = row + 1;//每行前后数差值
            System.out.print(preRow + dRow);//每行第一个数
            preCol = preRow + dRow;
            while (col <= n - row + 1){
                System.out.print(" ");
                System.out.print(preCol + dCol);
                preCol += dCol;
                ++dCol;
                ++col;
            }
            System.out.println();//换行
            preRow += dRow;
            ++row;
        }
    }
}
