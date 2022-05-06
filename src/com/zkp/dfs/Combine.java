package com.zkp.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 */
public class Combine {
    static List<List<Integer>> res;
    public static void main(String[] args){
        combine(6,2);
        System.out.println(res);
    }

    public static List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i=1;i<= k;i++){
            temp.add(i);//填充前k位
        }
        temp.add(n+1);//填充哨兵位
        int j =0;
        while(j< k){
            j=0;
            res.add(new ArrayList<>(temp.subList(0,k)));
            while(j < k && (temp.get(j) + 1 == temp.get(j+1))){
                temp.set(j,j+1);
                ++j;
            }
            //找到第一个j位置的数+1不等于j+1位置的数
            temp.set(j,temp.get(j)+1);//位置j的数自增1
        }
        return res;
    }


}
