package com.zkp.huawei;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author zkp
 * @version 1.0
 */
public class HJ21 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder output = new StringBuilder("");
        String inDict1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String outDict = "bcdefghijklmnopqrstuvwxyza22233344455566677778889999";
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if ((cur >= 65 && cur <= 90) || (cur >= 97 && cur <= 122)){
                int index = inDict1.indexOf(cur);
                output.append(outDict.charAt(index));
            }else
                output.append(cur);
        }
        System.out.println(output.toString());

    }
}
