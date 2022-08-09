package com.zkp.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zkp
 * @version 1.0
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果
 */
public class FindDisappearedNumbers {
    public static void main(String[] args){
       int[] nums = {4,3,2,7,8,2,3,1};
       System.out.println(find(nums));
    }
    public static List<Integer> find(int[] nums) {
        int n = nums.length;
        for(int i = 0;i < nums.length;i++){
            int x = (nums[i] - 1) % n;
            nums[x] +=  n;
        }
        List<Integer> ret = new ArrayList<>();
        for(int i=0;i < nums.length;i++){
            if(nums[i] <= n){
                ret.add(i + 1);
            }
        }
        return ret;
    }
}
