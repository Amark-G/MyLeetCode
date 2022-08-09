package com.zkp.math;

import java.util.*;

/**
 * @author zkp
 * @version 1.0
 */
public class FindContinuousSequence {
    public static void main(String[] args){
        FindContinuousSequence test = new FindContinuousSequence();
        System.out.println(test.find(100));

    }
    public ArrayList<ArrayList<Integer>> find(int sum) {
        if (sum == 0) return new ArrayList<>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        for (int x = 1; x <= sum / 2; x++) {//起始点
            int d = (int)(1 - 2 * x + Math.pow((2 * x - 1) * (2 * x - 1) + 8 * sum,0.5)) / 2;//步长
            if ((2 * x + d - 1) * d / 2 == sum) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = x; i < x + d; i++) {
                    temp.add(i);
                }
                ret.add(temp);
            }
        }
        return ret;
    }
}
