package com.zkp.algorithm.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 返回一个表示每个字符串片段的长度的列表。
 */
public class PartitionLabels {
    public static void main(String[] args){
       String str = "ababcbacadefegdehijhklij" ;
       System.out.println(partitionLabels2(str));
    }
    public static List<Integer> partitionLabels(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        int length = s.length();
        int i =0;
        while (i<length){
            int last = s.lastIndexOf(s.charAt(i));
            for (int j = i+1; j < last; j++) {
                    last= Math.max(s.lastIndexOf(s.charAt(j)), last);
            }
            list.add(last-i+1);
            i = last+1;
        }
        return list;
    }

    public static List<Integer> partitionLabels2(String s) {
        int length = s.length();
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(s.charAt(i),i);
        }
        int i =0;
        while (i<length){
            int last = map.get(s.charAt(i));
            for (int j = i+1; j < last; j++) {
                last= Math.max(map.get(s.charAt(j)), last);
            }
            list.add(last-i+1);
            i = last+1;
        }
        return list;
    }
}
