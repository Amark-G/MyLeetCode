package com.zkp.string;

import java.util.HashMap;

/**
 * @author zkp
 * @version 1.0
 */
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int[] dp = new int[s.length()];//dp[i]表示以i位置字符结尾的最长不重复子串长度
        HashMap<Character,Integer> map = new HashMap<>();
        dp[0] = 1;
        map.put(s.charAt(0) , 0);
        int ret = dp[0];
        int start = 0;
        for(int i = 1;i < s.length();i++){
            int index = map.getOrDefault(s.charAt(i),-1);
            if(index == -1){
                //不存在
                dp[i] = dp[i - 1] + 1;
            }else{
                start = Math.max(index, start);
                dp[i] = i - start;
            }
            map.put(s.charAt(i),i);
            ret = Math.max(dp[i], ret);
        }
        return ret;
    }
}
