package com.zkp.divide;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class DiffWaysToCompute {
    public static void main(String[] args){
        List<Integer> integers = diffWaysToCompute("2-1-1");
        System.out.println(integers);
    }
    
    public static List<Integer> diffWaysToCompute(String expression) {
        if (expression.length() < 1) return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        int index = 0;
        int num = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (!isOp(expression.charAt(i))){//不是运算符
                num = 10*num + expression.charAt(i)-'0';
                index +=1;
            }else{
                break;
            }
        }
        if (index==expression.length()){
            res.add(num);
            return res;
        }
        for (int i = 0; i < expression.length(); i++) {
            if (isOp(expression.charAt(i))){//如果是运算符，得到运算符两边表达式所有可能的运算结果
                String str1 = expression.substring(0, i);
                String str2 = expression.substring(i + 1);
                List<Integer> result1 = diffWaysToCompute(str1);//运算符左边表达式所有结果
                List<Integer> result2 = diffWaysToCompute(str2);//运算符右边表达式所有结果
                //遍历两边所有结果，二二组合运算
                for (int j = 0; j < result1.size(); j++) {
                    for (int k = 0; k < result2.size(); k++) {
                        res.add(compute(result1.get(j), expression.charAt(i), result2.get(k)));//将计算结果加入结果集
                    }
                }
            }
        }
        return res;
    }

    public static int compute(int num1 ,char c,int num2){
        switch (c){
            case('+') :
                return (num1 + num2);
            case('-'):
                return (num1 - num2);
            case('*'):
                return (num1 * num2);
            default: return 0;
        }
    }
    //判断是否是运算符
    public static boolean isOp(char c){
        return c=='+' || c=='-' || c=='*';
    }
}
