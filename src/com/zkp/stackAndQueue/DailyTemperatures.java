package com.zkp.stackAndQueue;

import java.util.Stack;

/**题739
 * 给定一个整数数组temperatures，表示每天的温度，
 * 返回一个数组answer，其中answer[i]是指在第 i 天之后，才会有更高的温度。
 * 如果气温在这之后都不会升高，请在该位置用0 来代替。
 *
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        //int maxT = temperatures[0];

        for (int i = 1; i < len -1; i++) {
            int count = 1;
            int curT = temperatures[i];
            for (int j = i+1; j < len; j++) {
                if (temperatures[j]<curT){
                    count ++;
                }else {

                    break;
                }
            }
            if (count==len-i)count=0;
            res[i-1]=count;
        }
        res[len-1]=0;
        return res;
    }
}
