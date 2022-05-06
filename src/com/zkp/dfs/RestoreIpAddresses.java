package com.zkp.dfs;
/**题93
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入'.' 来形成。你 不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。

 */

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public static void main(String[] args){
        //System.out.println(check("255.255.11.135",0,2));
        System.out.println(restoreIpAddresses("101023"));
    }
    static List<String> res ;
    public static List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        int len = s.length();
        if (len <4 || len >12) return res;
        backTracking(s,0,1);
        return res;
    }
    private static void backTracking(String s,int startIndex,int count){
        if (count==4) {
            if (check(s,startIndex,s.length()-1)){
                res.add(String.valueOf(s));
            }
            return;
        }
        for (int endIndex = startIndex; endIndex < startIndex + 3; endIndex++) {
            if (endIndex>=s.length()-1){
                return;
            }
            //每次有三种加"."选择
            String temp =s;
            s = s.substring(0,endIndex+1)+"."+s.substring(endIndex+1);
            if (check(s,startIndex,endIndex)){
                backTracking(s,endIndex+2,count+1);
                s = temp;
            }


        }
    }
    //判断这种加点方式是否合理
    private static boolean check(String str,int startIndex,int endIndex){
        String sub = str.substring(startIndex,endIndex + 1);
        if (sub.charAt(0)=='0' && !sub.equals("0")){
            return false;
        }
        int num = Integer.parseInt(sub);
        return num <= 255;
    }
}
