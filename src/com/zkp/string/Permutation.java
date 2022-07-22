package com.zkp.string;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author zkp
 * @version 1.0
 * 输入一个长度为 n 字符串，打印出该字符串中字符的所有排列，你可以以任意顺序返回这个字符串数组。
 */
public class Permutation {
    public static void main(String[] args){
        Permutation permutation = new Permutation();
        permutation.test("ab");
        HashSet<String> strings = new HashSet<>();
    }

    private ArrayList<String> ret = new ArrayList<>();
    public ArrayList<String> test (String str) {
        backTracking(new StringBuilder(str),new StringBuilder());
        return ret;
    }
    private void backTracking(StringBuilder str,StringBuilder sb) {
        if(str.length() == 0){
            ret.add(new String(sb));
            return;
        }
        for(int i = 0;i < str.length() ; i++){
            char c = str.charAt(i);
            System.out.println(c);
            sb.append(c);
            backTracking(str.deleteCharAt(i),sb);
            sb.deleteCharAt(sb.length() - 1);
            str.insert(i,c);
        }
    }
}
