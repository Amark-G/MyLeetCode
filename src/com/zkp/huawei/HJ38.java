package com.zkp.huawei;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author zkp
 * @version 1.0
 */
public class HJ38 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        int i = 1;
        double h = n/2;
        double sum = n;
        while (i < 5){
            sum += h*2;
            h = h/2;
            ++i;
        }
        DecimalFormat df = new DecimalFormat("0.000000");
        System.out.println(df.format(sum));
        System.out.println(df.format(h));
        System.out.println(df.format(65654.121));
    }
}
