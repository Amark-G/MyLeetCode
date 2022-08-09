package com.zkp.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zkp
 * @version 1.0
 */
public class HJ6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long k = (long)Math.pow(n, 0.5);//循环到根号n
        for (int i = 2; i <= k; i++) {
            while(n % i == 0){
                System.out.print(i + " ");
                n /= i;
            }
        }
        if(n != 1)
            System.out.print(n);
    }
}
