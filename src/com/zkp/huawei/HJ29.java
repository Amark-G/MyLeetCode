package com.zkp.huawei;

import java.util.Scanner;

/**
 * @author zkp
 * @version 1.0
 * 对输入的字符串进行加解密，并输出。
 *
 * 加密方法为：
 *
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 *
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 *
 * 其他字符不做变化。
 *
 * 解密方法为加密的逆过程。
 */
public class HJ29 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String encode = sc.nextLine();
        String decode = sc.nextLine();
        System.out.println(encoding(encode));
        System.out.println(decoding(decode));
    }

    /**
     * 加密函数
     * @param str 源字符串
     * @return 加密后字符串
     */
    private static String encoding(String str){
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c)){
                if (c == 'z' || c == 'Z')
                    c = (char) (c - 25);
                else
                    c = (char) (c + 1);
                c = change(c);
                ret.append(c);
            }else if (Character.isDigit(c)){
                ret.append((c - '0' + 1) % 10);
            }

        }
        return ret.toString();
    }

    /**
     * 解密函数
     * @param str 源字符串
     * @return 解密后字符串
     */
    private static String decoding(String str){
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c)){
                if (c == 'a' || c == 'A')
                    c = (char) (c + 25);
                else
                    c = (char) (c - 1);
                c = change(c);
                ret.append(c);
            }else if (Character.isDigit(c)){
                if (c == '0'){
                    c = '9';
                    ret.append(c);
                }else
                    ret.append(c - '0' - 1);
            }

        }
        return ret.toString();
    }

    /**
     * 变换大小写
     * @param c 字符
     * @return 字符
     */
    private static char change(char c){
        if (Character.isLowerCase(c))
            return Character.toUpperCase(c);
        else
            return Character.toLowerCase(c);
    }

}
