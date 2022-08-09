package com.zkp.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * @author zkp
 * @version 1.0
 */
public class PrintMinNumber {
    public static void main(String[] args){
        HashSet<Integer> set = new HashSet<>();
        
    }
    public String getMinNumber(int [] numbers) {
        //空数组的情况
        if(numbers == null || numbers.length == 0)
            return "";
        String[] nums = new String[numbers.length];
        //将数字转成字符
        for(int i = 0; i < numbers.length; i++)
            nums[i] = numbers[i] + "";
        //按照重载排序
        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return (s1 + s2).compareTo(s2 + s1);
            }
        });
        StringBuilder res = new StringBuilder();
        //字符串叠加
        for (String num : nums) res.append(num);
        return res.toString();
    }
}
