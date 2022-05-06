package com.zkp.algorithm.sort;

public class bubble {
    public static void main(String[] args){
       int[] test = Util.creatArr();
       test = bubble(test);
       Util.print(test);
    }

    public static int[] bubble(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length - i -1; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
