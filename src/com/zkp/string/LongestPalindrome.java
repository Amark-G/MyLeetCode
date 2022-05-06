package com.zkp.string;

import java.util.HashMap;
import java.util.Set;

/**
 * 给定一个包含大写字母和小写字母的字符串s，返回通过这些字母构造成的 最长的回文串。
 *
 * 在构造过程中，请注意 区分大小写 。比如"Aa"不能当做一个回文字符串。

 */
public class LongestPalindrome {
    public static void main(String[] args){
        String s = "abccccddABBCADSDADrafsaSFFSAFASFwwwwwww";
        int[] arr = new int[256];
        char c = 'z';
        arr[c] +=1;
        for (int i = 0; i < 256; i++) {
            if(arr[i] >0) System.out.println(i);
        }
    }

    public static int longestPalindrome(String s) {
        int len = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        //统计每个字符出现的次数
        for (int i = 0; i < len; i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        //统计所有偶数个字符;
        int sum =0;
        Set<Character> keySet = map.keySet();
        for (Character key : keySet) {
            int count  = map.get(key);
            sum+=count/2*2;
        }
        if (sum<len) sum+=1;
        return sum;

    }
}
