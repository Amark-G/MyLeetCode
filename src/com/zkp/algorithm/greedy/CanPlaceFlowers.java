package com.zkp.algorithm.greedy;

public class CanPlaceFlowers {

    public static void main(String[] args){
       int[] arr = {0,0,1,0,0};
        System.out.println(canPlaceFlowers(arr,1));
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if (len == 1){
            return n == 0 || (n == 1 && flowerbed[0] == 0);
        }else {
            if (flowerbed[0]==0 && flowerbed[1]==0) {
                flowerbed[0] = 1;
                n-=1;
            }
            if(n>0){
                for (int i = 1; i < len - 1; i++) {
                    if (flowerbed[i-1]==0&&flowerbed[i]==0&&flowerbed[i+1]==0){
                        flowerbed[i] =1;
                        n-=1;
                    }
                }
                return n==0 || (n==1 && flowerbed[len-2]==0&&flowerbed[len-1]==0);
            }

        }
        return true;
    }
}
