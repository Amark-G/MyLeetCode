package com.zkp.string;

/**
 * 将字符串向右循环移动 k 位。
 *
 * 将 abcd123 中的 abcd 和 123 单独翻转，得到 dcba321，然后对整个字符串进行翻转，得到 123abcd。
 *
 * 例如：
 * s = "abcd123" k = 3
 * Return "123abcd"
 */
public class StringCircularMove {

    public static void main(String[] args){
       String str = "abcd123";
       System.out.println(move(str,4));
    }

    public static String move(String str,int k){
        int len = str.length();
        k%=len;
        //分成前len-k长度部分和后面长度为k的部分
        String strTail = str.substring(len - k);
        String strPre = str.substring(0,len-k);
        //前部分和后部分分别反转
        strPre = reverse(strPre);
        strTail = reverse(strTail);
        str = reverse(strPre+strTail);
        return str;
    }
    //反转字符串
    public static String reverse(String str){
        int len = str.length();
        char[] chars = str.toCharArray();
        for (int i = 0; i < len / 2; i++) {
            char c =chars[i];
            chars[i] = chars[len-i-1];
            chars[len-i-1] = c;
        }
        return String.valueOf(chars);
    }
}
