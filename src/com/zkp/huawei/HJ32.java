package com.zkp.huawei;

import java.util.Scanner;

/**
 * @author zkp
 * @version 1.0
 * 最长回文子串
 */
public class HJ32 {
    static int max = 1;
    static String s;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        System.out.println(getLongest(s));
    }

    private static int getLongest(String str){
        int i = 0;
        while (i < str.length()){
            i = getNextIndex(str,i);
        }
        return max;
    }
    private static int getNextIndex(String str,int curIndex){
        int left = curIndex,right = curIndex;
        while (right < str.length() - 1 && str.charAt(left) == str.charAt(right + 1)){
            ++right;
        }
        int res = right + 1;//这里就能够找到下一个遍历的位置
        while (left > 0 && right < str.length() - 1 && str.charAt(left - 1) == str.charAt(right + 1)){
            --left;
            ++right;
        }
        max = Math.max(max,right - left + 1);
        return res;
    }
}
