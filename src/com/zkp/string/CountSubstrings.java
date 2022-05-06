package com.zkp.string;

import java.util.*;

/**题647
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 *
 * 回文字符串 是正着读和倒过来读一样的字符串。
 *
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。

 */
public class CountSubstrings {
    public static void main(String[] args){
       int a = 121;
       String str = String.valueOf(a);
       System.out.println(countSubstrings(str));
    }

    public static int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        if(len<2) return 1;
        int count=0;
        if (chars[0]==chars[1]) count+=1;
        for (int i = 1; i < len-1; i++) {
            int j=1;
            if(chars[i]==chars[i+1]) {
                int k=0;
                while (i-k>=0 && i+k+1<=len-1&&chars[i-k]==chars[i+k+1]){
                    count+=1;
                    k+=1;
                }
            }
            while(0<=i-j && i+j<=len-1&&chars[i-j]==chars[i+j]){
                    count+=1;
                    j+=1;
            }
        }
        count+=len;
        return count;
    }
}
