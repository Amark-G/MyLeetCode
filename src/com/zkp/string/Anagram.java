package com.zkp.string;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**题242
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 */
public class Anagram {

    public static void main(String[] args){
        String str1= "AACC";
        String str2= "ACAA";
        System.out.println(isAnagram(str1,str2));
        int[] a = new int[26];
        System.out.println(Arrays.equals(a,new int[26]));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        for (int i = 0; i < t.length(); i++) {
            if (!list.contains(t.charAt(i))){
                return false;
            }
            list.remove(Character.valueOf(t.charAt(i)));
        }
        return list.isEmpty();
    }

}
