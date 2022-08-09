package com.zkp.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author zkp
 * @version 1.0
 */
public class HJ5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        str = br.readLine();


        int ret = 0;
        int index = str.length() - 1;
        while (index >= 2){
            int tempNum = str.charAt(index) - '0';
            if(str.charAt(index) - '0' > 9)
                tempNum = str.charAt(index) - 55;
            ret += Math.pow(16,str.length() - 1 - index) * tempNum;
            --index;
        }
        System.out.println(ret);
    }
}
