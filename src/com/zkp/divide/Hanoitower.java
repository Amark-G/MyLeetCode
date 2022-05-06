package com.zkp.divide;

public class Hanoitower {
    public static void main(String[] args){
       hanoiTower(5, 'A', 'B', 'C');
    }
    public static void hanoiTower(int num,char a,char b,char c){
        if (num==1){
            System.out.println("第1个盘从 " + a +" 到 " + c);
        }else {
            //多个盘，分成最上面的盘和最底下的一个盘
            //上面的盘移到b先
            hanoiTower(num-1,a,c,b);
            //下面的盘移到c
            System.out.println("第" + num + "个盘从 " + a+" 到 " + c);
            //b柱子上的盘从b到c
            hanoiTower(num-1,b,a,c);
        }
    }
}
