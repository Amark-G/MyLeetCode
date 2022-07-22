package com.zkp.dp;

/**
 * @author zkp
 * @version 1.0
 */
public class FindMedianSortedArrays {
    public static void main(String[] args){
       int[] nums1 = {1,3};
       int[] nums2 = {2,6,33,66};
       double ret = findMedianSortedArrays(nums1, nums2);
       System.out.println(ret);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Start = 0;
        int nums1End = nums1.length - 1 ;
        int nums2Start = 0;
        int nums2End = nums2.length - 1;
        boolean flagA = nums1.length % 2 != 0;
        boolean flagB = nums2.length % 2 != 0;
        double midA,midB;
        while (nums1Start != nums1End && nums2Start != nums2End){
            //找两个区间的中间值
            midA = findMedian(nums1,nums1Start,nums1End);
            midB = findMedian(nums2,nums2Start,nums2End);
            //判断中间值的大小
            if (midA>midB){
                nums1End = flagA ? (nums1End - nums1Start)/2 - 1 : (nums1End - nums1Start)/2;
                nums2Start =((nums2End - nums2Start)/2) + 1;
            }else if (midA < midB){
                nums2End = flagB ? (nums2End - nums2Start)/2 - 1 : (nums2End - nums2Start)/2;
                nums1Start = ((nums1End - nums1Start)/2) + 1;
            }else {
                return midA;
            }
            flagA = (nums1End - nums1Start + 1) %2 != 0;
            flagB = (nums2End - nums2Start + 1) %2 != 0;
        }
        if (nums1Start == nums1End && nums2Start == nums2End){
            return (nums1[nums1Start] + nums2[nums2Start]) / 2.0;
        }

        if (nums1Start == nums1End){
           return (nums1[nums1Start] + nums2[nums2Start] + nums2[nums2End] - Math.min(Math.min(nums1[nums1Start],nums2[nums2Start]),nums2[nums2End]))/2.0;
        }else {
           return (nums2[nums1Start] + nums1[nums2Start] + nums1[nums2End] - Math.min(Math.min(nums2[nums1Start],nums1[nums2Start]),nums1[nums2End]))/2.0;
        }

    }

    //找区间的中位数值
    private static double findMedian (int[] arr,int startIndex,int endIndex){
        if ((endIndex - startIndex + 1) %2 == 0){
            //偶数位
            return (arr[startIndex + (endIndex - startIndex)/2] + arr[startIndex + (endIndex - startIndex)/2 + 1])/2.0;
        }else {
            return arr[startIndex + (endIndex - startIndex)/2];
        }
    }
}
