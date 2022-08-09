package com.zkp.huawei;

import java.util.Scanner;

/**
 * @author zkp
 * @version 1.0
 */
public class HJ22 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            if (n == 0)
                break;
            System.out.println(compute(n));
        }
    }
    private static int compute(int n){
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        return n/3 + compute(n/3 + n % 3);
    }
}
