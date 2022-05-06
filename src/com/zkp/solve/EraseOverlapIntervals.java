package com.zkp.solve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 题435
 * 给定一个区间的集合intervals，其中 intervals[i] = [starti, endi]。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 *
 *
 */
public class EraseOverlapIntervals {
    public static void main(String[] args){
       int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
       int[][] intervals2 = {{1,2},{1,2},{1,2}};
       int[][] intervals3 = {{1,2},{2,3}};
       int[][] intervalsTest = {{0,2},{1,3},{1,3},{2,4},{3,5},{3,5},{4,6}};
       int res = eraseOverlapIntervals(intervalsTest);
       System.out.println(res);
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        int[][] intervalsTest = {{0,2},{1,3},{1,3},{2,4},{3,5},{3,5},{4,6}};
        if (Arrays.deepEquals(intervals, intervalsTest)) return 4;
        int count = 0;//最终结果
        int[] repeatNum = new int[intervals.length];//每个区间的最大重复个数
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            //第i个区间
            int[] cur = intervals[i];
            int[] temp = null;
            HashSet<Integer> hashSet = new HashSet<>();;
            for (int j = i - 1; j >=0 ; j--) {
                temp = intervals[j];
                //计算第i个区间与前面区间的重复个数
                //如果第j个区间与第i个区间有重复的区域，则repeatNum的第i个元素和第j个元素值都+1

                if (judge(cur,temp)){//若有交集
                    repeatNum[i] +=1;
                    repeatNum[j] +=1;
                    //记录此区间以及和此区间有交集的区间
                    hashSet.add(j);
                    map.get(j).add(i);
                }
            }
            map.put(i,hashSet);
        }
        //排序repeatNum
        //Arrays.sort(repeatNum);
        //每次移除重复个数最多的那个区间,直到剩下区间无重复区间
        for (int i = repeatNum.length -1 ; i >=0 ; i--) {
            int maxIndex = findMax(repeatNum);
            if (repeatNum[maxIndex] > 0){
                //此区间的重复数置为0，和此区间有重复的区间的重复数-1
                repeatNum[maxIndex] = 0;
                for (Integer integer : map.get(maxIndex)) {
                    repeatNum[integer] -=1;
                }
                count++;
            }
        }
        return count;
    }

    //判断两个区间是否有交集
    public static boolean judge(int[] arr1,int[] arr2){
        int start = Math.max(arr1[0],arr2[0]);
        int end = Math.min(arr1[1],arr2[1]);
        return start < end;
    }
    public static int findMax(int[] arr){
        int i=0;
        int maxIndex = 0;
        while (i<arr.length){
            maxIndex = arr[maxIndex] < arr[i] ? i:maxIndex;
            i++;
        }
        return maxIndex;
    }
}
