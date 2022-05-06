package com.zkp.algorithm.sort;

public class Insert {
    public static void main(String[] args){
       int[] test = Util.creatArr();
       Util.print(insert(test));
    }
    public static int[] insert(int[] arr){
        for (int i = 1; i <arr.length ; i++) {
            for (int j = i; j > 0 ; j--) {
                if (arr[j] < arr[j -1]){
                    int temp =arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        return arr;
    }
}
