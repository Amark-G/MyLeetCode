package com.zkp.string;

import java.util.Locale;

/**
 * @author zkp
 * @version 1.0
 */
public class StrToInt {

    public static void main(String[] args){
        StrToInt test = new StrToInt();
        System.out.println(test.stringToInt("-987654321111"));
    }

    public int stringToInt (String s) {
        //空串
        if(s.isEmpty())
            return 0;
        int res = 0;
        int index = 0;
        int n = s.length();
        //去掉前导空格，如果有
        while(index < n){
            if(s.charAt(index) == ' ')
                index++;
            else
                break;
        }
        //去掉空格就什么都没有了
        if(index == n)
            return 0;
        int sign = 1;
        //处理第一个符号是正负号的情况
        if(s.charAt(index) == '+')
            index++;
        else if(s.charAt(index) == '-'){
            index++;
            sign = -1;
        }
        //去掉符号就什么都没有了
        if(index == n)
            return 0;
        while(index < n){
            char c = s.charAt(index);
            //后续非法字符，截断
            if(c < '0' || c > '9')
                break;
            //处理越界
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (c - '0') > Integer.MAX_VALUE % 10))
                return Integer.MAX_VALUE;
            if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (c - '0') > -(Integer.MIN_VALUE % 10)))
                return Integer.MIN_VALUE;
            res = res * 10 + sign * (c - '0');
            index++;
        }
        return res;
    }

}
