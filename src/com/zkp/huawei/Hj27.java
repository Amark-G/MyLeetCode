package com.zkp.huawei;

import java.util.*;

/**
 * @author zkp
 * @version 1.0
 */
public class Hj27 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int n = Integer.parseInt(strings[0]);

        ArrayList<String> dict = new ArrayList<>();//兄弟单词
        for (int i = 1; i < strings.length - 2; i++) {
            dict.add(strings[i]);
        }
        String source = strings[strings.length - 2];
        int k = Integer.parseInt(strings[strings.length - 1]);
        //获取source的全部兄弟的单词

        ArrayList<String> list = new ArrayList<>();
        char[] chars = source.toCharArray();
        Arrays.sort(chars);
        backTracking(chars,chars.length,list,new StringBuilder(""),new boolean[chars.length]);
        list.remove(source);

        ArrayList<String> brother = new ArrayList<>();
        for (String s : dict) {
            if (list.contains(s))
                brother.add(s);
        }
        Collections.sort(brother);
        System.out.println(brother.size());
        if (k <= brother.size())
            System.out.println(brother.get(k - 1));
    }

    private static void backTracking(char[] chars, int len, List<String> ret,StringBuilder temp,boolean[] visit){
        if (temp.length() == len){
            ret.add(temp.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visit[i] || (i > 0 && !visit[i - 1] && chars[i] == chars[i - 1]))
                continue;
            visit[i] = true;
            temp.append(chars[i]);
            backTracking(chars,len,ret,temp,visit);
            temp.deleteCharAt(temp.length() - 1);//回溯
            visit[i] = false;//回溯
        }
    }
}
