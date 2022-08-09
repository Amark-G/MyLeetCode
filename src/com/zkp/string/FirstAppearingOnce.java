package com.zkp.string;

import java.util.HashMap;

/**
 * @author zkp
 * @version 1.0
 */
public class FirstAppearingOnce {

    public static void main(String[] args){
        FirstAppearingOnce test = new FirstAppearingOnce();
        String str = "google";
        for (int i = 0; i < str.length(); i++) {
            test.Insert(str.charAt(i));
            System.out.println(test.find());
        }
    }

    StringBuilder s = new StringBuilder();
    HashMap<Character, Integer> map = new HashMap<>();

    public void Insert(char ch) {
        s.append(ch);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    public char find() {
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return '#';
    }
}
