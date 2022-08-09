package com.zkp.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author zkp
 * @version 1.0
 * 密码要求:
 *
 * 1.长度超过8位
 *
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 *
 * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
 */
public class HJ20 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while (sc.hasNext()){
            list.add(sc.nextLine());
        }
        for (int i = 0; i < list.size(); i++) {
            if (check(list.get(i)))
                System.out.println("OK");
            else
                System.out.println("NG");
        }
    }
    private static boolean check(String password){
        if (password.length() <= 8)
            return false;
        int count = 0;
        Pattern pattern1 = Pattern.compile("[0-9]") ;
        Pattern pattern2 = Pattern.compile("[a-z]");
        Pattern pattern3 = Pattern.compile("[A-Z]");
        Pattern pattern4 = Pattern.compile("[^a-z0-9A-Z]");
        if (pattern1.matcher(password).find())
            ++count;
        if (pattern2.matcher(password).find())
            ++count;
        if (pattern3.matcher(password).find())
            ++count;
        if (pattern4.matcher(password).find())
            ++count;

        if (count < 3)
            return false;
        //检查是否含有长度超过2的重复子串
        return checkRepeat(password,0,3);
    }

    private static boolean checkRepeat(String password,int l,int r){
        if (r >= password.length())
            return true;
        if (password.substring(l + 1).contains(password.substring(l,r)))
            return false;
        else
            return checkRepeat(password,l+1,r+1);
    }
}

