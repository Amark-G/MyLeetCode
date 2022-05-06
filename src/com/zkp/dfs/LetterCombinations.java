package com.zkp.dfs;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

/**题17
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LetterCombinations {
    private static final String[] word = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void main(String[] args){

        System.out.println(letterCombinations(""));
    }
    static List<String> res = new ArrayList<>();
    public static List<String> letterCombinations(String digits) {
        if(digits.equals("")){
            //res.add("");
            return res;
        }
       dfs(digits,0,new StringBuilder(""));
        return res;
    }
    private static void dfs(String digits,int height,StringBuilder add){
        //如果已经遍历完所有数字
        if (height == digits.length()){
            res.add(String.valueOf(add));
            return;
        }
        //得到当前数字代表的字符串
        int num = Integer.parseInt(String.valueOf(digits.charAt(height)));
        String str = word[num-2];
        for (int i = 0; i < str.length(); i++) {
            add.append(str.charAt(i));
            dfs(digits,height+1,add);
            add.deleteCharAt(height);
        }
    }

}
