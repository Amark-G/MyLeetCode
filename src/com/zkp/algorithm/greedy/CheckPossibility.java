package com.zkp.algorithm.greedy;

/**
 * 给你一个长度为n的整数数组nums，请你判断在 最多 改变1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的：对于数组中任意的i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 */
public class CheckPossibility {
    public static void main(String[] args){
       int[] arr ={1,8,2,4,9};
       System.out.println(checkPossibility(arr));
    }
    public static boolean checkPossibility(int[] nums) {
        int len = nums.length;
        if (len<3) return true;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] > nums[i+1]){
                int temp = nums[i];
                nums[i] = nums[i+1];
                if (check(nums,len)){
                    return true;
                } else {
                    nums[i] = temp;
                    nums[i+1] = temp;
                    return check(nums,len);
                }
            }
        }
        return true;
    }
    public static boolean check(int[] nums,int length){
        if (length<2) return true;
        for (int i = 0; i < length -1; i++) {
            if (nums[i] > nums[i+1]) {
                return false;
            }
        }
        return true;
    }
}
