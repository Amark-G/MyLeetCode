package com.zkp.dfs;

import java.util.ArrayList;
import java.util.List;

/**题131
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 */
public class Partition {

    public static void main(String[] args){
       String s = "aabb";
        Partition partition = new Partition();
        System.out.println(partition.partition(s));
    }
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backTracking(s,0,temp);
        return res;
    }
    private void backTracking(String s,int beginIndex,List<String> temp){
        if (beginIndex == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = beginIndex + 1; i <= s.length(); i++) {
                String str = s.substring(beginIndex,i);
                if (check(str)){
                    temp.add(str);
                    backTracking(s,i,temp);
                    temp.remove(temp.size() - 1);
                }
        }
    }

    /**
     * 判断字符串str从beginIndex到endIndex是否是回文字符串
     * @param str
     * @return
     */
    private boolean check(String str){
        int beginIndex = 0;
        int endIndex = str.length() - 1;
        while (beginIndex < endIndex){
            if (str.charAt(beginIndex) != str.charAt(endIndex)) return false;
            ++beginIndex;
            --endIndex;
        }
        return true;
    }
}
