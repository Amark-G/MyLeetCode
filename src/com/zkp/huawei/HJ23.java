package com.zkp.huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * @author zkp
 * @version 1.0
 */
public class HJ23 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int min = 21;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        Set<Character> keySet = map.keySet();
        for (Character c : keySet) {
            min = Math.min(min,map.get(c));
        }
        StringBuilder out = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.get(c) != min){
                out.append(c);
            }
        }
        System.out.println(out.toString());

    }
}
