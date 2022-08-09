package com.exam;

/**
 * @author zkp
 * @version 1.0
 */
public class Solution2 {
    public static void main(String[] args){
       int n = 12;
        System.out.println(findGreaterNum(n));
    }
    public static int findGreaterNum (int N) {

        String str = String.valueOf(N);
        int len = str.length();
        int[] nums = new int[len];
        //填充nums
        for (int i = 0; i < len; i++) {
            nums[i] = str.charAt(i) - '0';
        }
        int i=len - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }

        if(i >= 0){
            int j = len - 1;
            while (j >= 0 && nums[i] >= nums[j]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);
        int ret = 0;
        for (int j = 0; j < len; j++) {
            ret = ret *10 + nums[j];
        }

        return ret < N ? -1:ret;
    }
    private static void reverse(int[] nums,int start){
        int left = start;
        int right = nums.length - 1;
        while (left < right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }
    private static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
