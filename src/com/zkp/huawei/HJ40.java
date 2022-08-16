package com.zkp.huawei;

import java.util.Scanner;

/**
 * @author zkp
 * @version 1.0
 */
public class HJ40 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int letter = 0,space = 0,digit = 0,elseChar = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c))
                ++letter;
            else if (Character.isDigit(c))
                ++digit;
            else if (c == ' ')
                ++space;
            else
                ++elseChar;
        }
        System.out.println(letter);
        System.out.println(space);
        System.out.println(digit);
        System.out.println(elseChar);
    }
}
