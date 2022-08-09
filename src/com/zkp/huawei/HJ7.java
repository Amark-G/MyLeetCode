package com.zkp.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zkp
 * @version 1.0
 */
public class HJ7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        input = bf.readLine();
        float n = Float.parseFloat(input);
        int d = (int)n;
        if (n - d >= 0.5)
            System.out.println(d + 1);
        else
            System.out.println(d);
    }
}
