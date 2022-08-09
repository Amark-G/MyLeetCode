package com.zkp.huawei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author zkp
 * @version 1.0
 */
public class HJ26 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (Character.isLetter(cur)){
                list.add(cur);
            }
        }
        StringBuilder ret = new StringBuilder("");
        list.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Integer.compare(Character.toLowerCase(o1) - Character.toLowerCase(o2), 0);
            }
        });
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (Character.isLetter(cur)){
                ret.append(list.get(index++));
            }else{
                ret.append(cur);
            }
        }
        System.out.println(ret.toString());
    }

}
