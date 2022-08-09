package com.zkp.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zkp
 * @version 1.0
 */
public class HJ13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        str = br.readLine();
        int startIndex = 0;
        str = str + " ";
        String out = "";
        while(startIndex < str.length()){
            int endIndex = startIndex;
            while(endIndex <= str.length()){
                if(str.charAt(endIndex) == ' '){
                    out = " " + str.substring(startIndex,endIndex) + out;
                    break;
                }
                ++endIndex;
            }
            startIndex = endIndex + 1;
        }
        System.out.print(out.substring(1));
    }
}
