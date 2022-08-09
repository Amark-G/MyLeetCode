package com.zkp.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zkp
 * @version 1.0
 */
public class SubarraySum {
    public static void main(String[] args){
       int[] test = {1,1,1};


       System.out.println(new SubarraySum().subarraySum(test, 2));
    }

    public int subarraySum(int[] nums, int k) {
        List<ArrayList<Integer>> sumList = new ArrayList<>();
        int len = nums.length;
        int ret = 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        sumList.add(list);
        for(int i = 1;i < len;i++){
            ArrayList<Integer> listCur = new ArrayList<>();
            ArrayList<Integer> preList = sumList.get(i - 1);
            listCur.add(nums[i]);
            for(int j = 0;j < preList.size();j++){
                int temp = nums[i] + preList.get(j);
                listCur.add(temp);
            }
            sumList.add(listCur);
        }
        for(int i = 0;i < len;i++){
            ArrayList<Integer> listCur = sumList.get(i);
            for(Integer cur : listCur){
                if(cur == k)
                    ret++;
            }
        }
        return ret;
    }
}
