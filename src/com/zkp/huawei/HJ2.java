package com.zkp.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * @author zkp
 * @version 1.0
 */
public class HJ2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String target = br.readLine();
        str = str.toUpperCase(Locale.ROOT);
        target = target.toUpperCase(Locale.ROOT);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target.charAt(0))
                ++count;
        }
        System.out.println(count);
    }
}
