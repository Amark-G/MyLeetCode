package com.zkp.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zkp
 * @version 1.0
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * 动态规划
 * dp[i] 表示0~i-1 组成的字符串能否由字典中单词拼出
 * dp[i]:从 0 到找个 j 使得 dp[j] && 字典wordDict.contains(s.substring(j,i)) == true;
 * 找不到则dp[i] = false;
 */
public class WordBreak {
    public static void main(String[] args){
       String str = "ddadddbdddadd";
       List<String> wordDict = new ArrayList<>();
       wordDict.add("dd");
       wordDict.add("ad");
       wordDict.add("da");
       wordDict.add("b");

       WordBreak test = new WordBreak();
       System.out.println(test.check(str, wordDict));

    }

    public boolean check(String s, List<String> wordDict) {

        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        int maxLen = 0;
        for(String str : wordDict)
            maxLen = Math.max(maxLen,str.length());
        for(int i = 1 ; i <= len ; i++){
            for(int j = 0;j < i;j++){
                if(i - j > maxLen) continue;
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
