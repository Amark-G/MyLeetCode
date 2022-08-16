package com.zkp.huawei;

import java.util.Scanner;

/**
 * @author zkp
 * @version 1.0
 */
public class HJ37 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int one = 1,two = 0,three = 0;
        int cur = 1;
        while (cur <= n){
            int oldOne = one,oldTwo = two,oldThree = three;
            one = oldThree;
            two = Math.max(oldOne - oldTwo, 0);
            three = oldTwo + oldThree;
            ++cur;
        }
        System.out.println(one + " " + two + " " + three);
        System.out.println(one + two + three);
    }
}
