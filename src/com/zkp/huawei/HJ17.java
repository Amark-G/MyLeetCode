package com.zkp.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zkp
 * @version 1.0
 */
public class HJ17 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] input = str.split(";");
        int x = 0,y = 0;
        for (int i = 0; i < input.length; i++) {
            String cur = input[i];
            if (check(cur)){
                int move = Integer.parseInt(cur.substring(1));
                switch (cur.charAt(0)){
                    case 'A':
                        x -= move;
                        break;
                    case 'W':
                        y += move;
                        break;
                    case 'S':
                        y -= move;
                        break;
                    case 'D':
                        x += move;
                        break;
                }
            }
        }
        System.out.println(x + "," + y);
    }

    private static boolean check(String str){
        String regexp = "^(A|W|S|D)[0-9]?[0-9]$";
        return str.matches(regexp);
    }

}
