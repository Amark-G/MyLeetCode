package com.zkp.string;

/**
 * 给定两个字符串 s1 和 s2，要求判定 s2 是否能够被 s1 做循环移位得到的字符串包含。
 *
 * s1 进行循环移位的结果是 s1s1 的子字符串，因此只要判断 s2 是否是 s1s1 的子字符串即可。
 *
 * 例如：
 * s1 = AABCD, s2 = CDAA
 * Return : true
 */
public class StringCircularContain {
    public static void main(String[] args){
       String s1 = "ABCD";
       String s2 = "BCDABCDABCDA";
       System.out.println(judge(s1,s2));
    }

    public static boolean judge(String s1,String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        while(len1<len2){
            s1 +=s1;
            len1 = s1.length();
        }
        s1+=s1;
        return s1.contains(s2);
    }
}
