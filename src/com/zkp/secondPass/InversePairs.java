package com.zkp.secondPass;


import java.util.Arrays;

/**
 * @author zkp
 * @version 1.0
 */
public class InversePairs {
    public static void main(String[] args){
        InversePairs test = new InversePairs();
        int[] array = {1,2,3,4,5,6,7,0};
        int[] arr = {3,2,1,0};
        Arrays.sort(arr,1,4);
        System.out.println(test.findPairs(array));
        //System.out.println(Arrays.toString(arr));
    }

    public int mod = 1000000007;
    public int findPairs(int[] array) {
        if(array.length < 2) return 0 % 1000000007;
        int ret = 0;
        int len = array.length;
        for(int i = 0;i < len - 1;i++){
            int[] find = Arrays.copyOf(array,array.length);
            int cur = findCount(array[i],find,i + 1);
            ret += cur;
            ret %= mod;
        }
        return ret;
    }

    private int findCount(int target,int[] arr,int beginIndex){
        Arrays.sort(arr,beginIndex,arr.length);
        int left = beginIndex;
        int right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] >= target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return right + 1 - beginIndex;
    }
}
