package com.zkp.huawei;


import java.util.Scanner;

/**
 * @author zkp
 * @version 1.0
 */
public class HJ31 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split("[^a-zA-Z]+");
        StringBuilder ret = new StringBuilder();
        for (int i = strs.length - 1; i > 0 ; i--) {
            ret.append(strs[i] + " ");
        }
        ret.append(strs[0]);
        System.out.println(ret);
    }
}
