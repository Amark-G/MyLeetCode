package com.zkp.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class Util {
    public static void main(String[] args){
       int test[] = creatArr();
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }
    public static int[] creatArr(){
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = (int)(Math.random()*101);
        }
        return arr;
    }
    public static void print(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
