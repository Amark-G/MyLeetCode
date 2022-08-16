package com.zkp.huawei;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author zkp
 * @version 1.0
 */
public class HJ45 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = sc.nextLine();
        }
        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];
            int[] count = new int[26];//记录每个字母的出现频率
            for(int j = 0; j < str.length();j++){
                char c = str.charAt(j);
                --count[c - 'a'];
            }
            Arrays.sort(count);
            int sum = 0;
            int index = 0;
            for(int k = 0;k < 26; k++){
                if(count[k] != 0){
                    sum +=(26 - index) * -count[k];
                    ++index;
                }
            }
            System.out.println(sum);
        }
    }
}
