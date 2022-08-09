package com.zkp.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author zkp
 * @version 1.0
 * 对于给定正整数数组A和给定正整数T，请在A中找出两个连续子数组，这两个子数组不能相交，并且两个子数组的和相等且为 T。
 * 可能会有多种方案，请返回两个子数组长度和的最小值。如果无法找到这样的方案，请返回 -1。
 */
public class MinSumOfLengths {
    public static void main(String[] args){
        int[] array = {7,3,4,7};
        int T = 7;
        System.out.println(find(array, T));
    }

    public static int find(int[] array,int target){
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0;
        while(left < array.length){
            int sum = 0;
            int nextIndex = left + 1;
            for (int right = left; right < array.length; right++) {
                sum += array[right];
                if(sum == target) {
                    res.add(right - left + 1);
                    nextIndex = right + 1;
                    break;
                } else if(sum > target){

                    break;
                }
            }
            left = nextIndex;
        }
        if (res.size() < 2) return -1;
        else{
            Collections.sort(res);
            return res.get(0) + res.get(1);
        }

    }
}
