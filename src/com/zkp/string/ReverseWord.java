package com.zkp.string;

import java.util.HashSet;

/**
 *  字符串中单词的翻转
 *  将每个单词翻转，然后将整个字符串翻转。
 */
public class ReverseWord {

    public static void main(String[] args){
       String str ="I am";
       String res = reverseWord(str);
       System.out.println(res);
    }

    public static String reverseWord(String str){

        int len = str.length();
        char[] chars = str.toCharArray();
        //定位每一个单词
        int i=0;
        int j=0;
        while (j<len-1){
            if(chars[j+1]==' '){
                //反转单词
                reverse(chars,i,j);
                i=j+2;
                j=i;
            }else {
                j+=1;
            }
        }
        //反转最后一个单词
        reverse(chars,i,j);
        //反转整个字符串
        reverse(chars,0,len-1);
        return String.valueOf(chars);
    }

    public static void reverse(char[] chars,int i,int j){
        for (int k = i; k < i+(j - i+1) / 2; k++) {
            char c = chars[k];
            chars[k] = chars[j-k+i];
            chars[j-k+i] = c;
        }
    }
}
