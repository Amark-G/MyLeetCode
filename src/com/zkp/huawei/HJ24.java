package com.zkp.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zkp
 * @version 1.0
 */
public class HJ24 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] s = sc.nextLine().split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(s[i]));
        }
        System.out.println(list.size());
        int[] increase = longestIncrease(list);
        int[] reduce = longestReduce(list);
        //寻找最长递增子序列 + 最长递减子序列 最大的位置
        int ret = 1;
        for (int i = 1; i < n; i++) {
            ret = Math.max(ret,increase[i] + reduce[i] - 1);
        }
        System.out.println(n - ret);

    }
    private static int[] longestIncrease(List<Integer> list){
        //寻找最长递增子序列的长度
        int[] dp = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (list.get(j) < list.get(i))
                    dp[i] = Math.max(dp[i],dp[j] + 1);
            }
        }
        return dp;
    }
    private static int[] longestReduce(List<Integer> list){
        //寻找最长递减子序列的长度
        int[] dp = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = list.size() - 1; j > i ; j--) {
                if (list.get(j) < list.get(i))
                    dp[i] = Math.max(dp[i],dp[j] + 1);
            }

        }
        return dp;
    }
}
