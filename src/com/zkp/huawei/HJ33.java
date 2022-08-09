package com.zkp.huawei;

import java.util.Scanner;

/**
 * @author zkp
 * @version 1.0
 */
public class HJ33 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] decode = sc.nextLine().split("\\.");//转为十进制
        String encode = sc.nextLine();//转为二进制ip
        StringBuilder out1 = new StringBuilder();
        for (int i = 0; i < decode.length; i++) {
            out1.append(toBinaryString(decode[i]));
        }
        System.out.println(toNum(out1.toString()));
        System.out.println(getIP(encode));
    }

    /**
     * 十进制数字转化为二进制
     * @param str 字符串
     * @return 字符串
     */
    private static String toBinaryString(String str){
        String ret =  Integer.toBinaryString(Integer.parseInt(str));
        while (ret.length() < 8)
            ret = "0" + ret;
        return ret;
    }

    /**
     * 将数字转化为ip
     * @param str 字符串
     * @return 字符串
     */
    private static String getIP(String str){
        String temp = Long.toBinaryString(Long.parseLong(str));
        StringBuilder ret = new StringBuilder();
        while (temp.length() < 32)
            temp = "0" + temp;
        //分段
        int left = 0,right = 8;
        while (right <= 32){
            String segment = temp.substring(left,right);
            //将每段转换为十进制
            long num = toNum(segment);

            left += 8;
            right += 8;
            ret.append(num);
            if (right != 40)
                ret.append(".");

        }
        return ret.toString();
    }

    //二进制字符串转为十进制数字
    private static long toNum(String str){
        long ret = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            ret += (str.charAt(i) - '0') * Math.pow(2,str.length() - i - 1);
        }
        return ret;
    }
}
