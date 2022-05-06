package com.zkp.string;


import java.util.*;

public class Test {

    public static void main(String[] args){
        int[] arr = {1,3,4,2,2};
        long  a = 0;
        System.out.println(findDuplicate(arr));
    }

    public static int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int left = 1,right = n;
        int mid;
        int ans = -1;
        while(left<=right){
            mid = left + ((right - left)>>1);
            int count=0;
            for(int i=0;i<=n;i++){
                if(nums[i] <=mid){
                    ++count;
                }
            }
            if(count <= mid){
                left = mid +1;
            }else{
                right = mid - 1;
                ans=mid;
            }
        }
        return ans;
    }
}
