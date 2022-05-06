package com.zkp.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LadderLength {
    public static void main(String[] args){
        String[] w = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(ladderLength("hit","cog", List.of(w)));
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        if (beginWord.equals(endWord) || len != endWord.length() || !wordList.contains(endWord)) return 0;
        int res=1;
        Queue<String> queue = new LinkedList<>();
        List<String> record = new ArrayList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                String str = queue.poll();
                for (String word : wordList) {
                    if (checkOne(str, word) && !record.contains(word)) {
                        if (word.equals(endWord)) return ++res;
                        queue.offer(word);
                        record.add(word);
                    }
                }
                --size;
            }
            ++res;
        }
        return 0;
    }
    //判断是否只有index位置一个字符不同
    private static boolean checkOne(String str1,String str2){
        int len = str2.length();
        if (len!=str1.length() || str1.equals(str2)) return false;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (count>1)return false;
            if (str1.charAt(i) != str2.charAt(i)){
                ++count;
            }
        }
        return count<2;
    }

}
