package com.zkp.algorithm.sort;

import java.util.ArrayList;

public class Select {
    public static void main(String[] args){
          int test[] = Util.creatArr();
          test = select(test);
          Util.print(test);

    }
    public static int[] select(int arr[]){
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = i;
            for (int j = i + 1; j < arr.length ; j++) {
                if (arr[j] < arr[temp]){
                    temp = j;
                }
            }
            int t = arr[i];
            arr[i] = arr[temp];
            arr[temp] = t;
        }
        return arr;
    }


}
