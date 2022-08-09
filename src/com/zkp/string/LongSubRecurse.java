package com.zkp.string;

/**
 * @author zkp
 * @version 1.0
 * 给你一个字符串 s，找到 s 中最长的回文子串
 *扩散法
 */

public class LongSubRecurse {

    public static void main(String[] args){
        System.out.println(longestPalindrome("cbbd"));
    }
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int[] range = new int[2];//最长回文子串的起始位置和终止位置
        for (int i = 0; i < s.length() - 1; i++) {
            i = findNextIndex(i, range, s);//每次找下个起始位置
        }
        return s.substring(range[0],range[1] + 1);
    }
    private static int findNextIndex(int low,int[] range,String str){
        int high = low;
        while (high < str.length() - 1 && str.charAt(high + 1) == str.charAt(low)){
            high++;
        }
        int nextIndex = high;
        //开始向两边扩散
        while (low > 0 && high < str.length() - 1 && str.charAt(low - 1) == str.charAt(high + 1)){
            low--;
            high++;
        }
        //更新最长回文子串的坐标
        if (high - low > range[1] - range[0]){
            range[0] = low;
            range[1] = high;
        }
        return nextIndex;
    }
}
