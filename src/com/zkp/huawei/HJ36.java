package com.zkp.huawei;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author zkp
 * @version 1.0
 * 有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。下面是它的工作原理：首先，选择一个单词作为密匙，如TRAILBLAZERS。如果单词中包含有重复的字母，只保留第1个，将所得结果作为新字母表开头，并将新建立的字母表中未出现的字母按照正常字母表顺序加入新字母表。如下所示：
 * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 * T R A I L B Z E S C D F G H J K M N O P Q U V W X Y
 * trailblazers
 * abcd
 */
public class HJ36 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String decode = sc.nextLine();//等待解密字符串
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            String c = str.charAt(i) + "";
            if (input.indexOf(c) == -1)
                input.append(c);
        }
        System.out.println("去重后的字符串：" + input);
        HashMap<Character, Character> map = new HashMap<>();//存储对应关系
        for (int i = 0; i < input.length(); i++) {
            char key = (char) (97 + i);
            char value = input.charAt(i);
            map.put(key,value);
        }
        System.out.println( "部分map：" + map);
        String source = "abcdefghijklmnopqrstuvwxyz";
        int startIndex = input.length();
        for (int i = 0; i < source.length(); i++) {
            String c = source.charAt(i) + "";
            if (input.indexOf(c) == -1){
                char key = (char)(startIndex + 97);
                char value = source.charAt(i);
                map.put(key,value);
                ++startIndex;
            }
        }
        System.out.println(map);
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < decode.length(); i++) {
            ret.append(map.get(decode.charAt(i)));
        }
        System.out.println(ret);
    }
}
