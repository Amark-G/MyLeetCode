package com.zkp.dp;

import java.util.*;

/**
 * @author zkp
 * @version 1.0
 * 带权的区间调度问题
 */
public class BestTaskOrder {

    public static void main(String[] args){
       int[][] arr = {{3,0,6},{1,1,4},{4,3,5},{17,3,8},{9,4,7},{10,5,9},{8,6,10},{1,8,11}};
        System.out.println(Arrays.toString(schedule(arr)));

    }

    //arr[i][0] = w[i].arr[i][1] = start,arr[i][2] = end[i];
    public static int[] schedule(int[][] arr) {
        int n = arr.length;
        Task[] tasks = new Task[n];
        for (int i = 0; i < n; i++) {
            tasks[i] = new Task(arr[i], i);
        }
        //按照结束时间排序
        Arrays.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.arr[2] - o2.arr[2];
            }
        });
        //创建数组p,p[i]表示与任务i相容且下标最大的任务
        int[] p = new int[n];
        //遍历任务数组，找到第一个结束时间比任务i的开始时间早的任务k,p[i] = k;
        for (int i = 0; i < n; i++) {
            int startTime = tasks[i].arr[1];
            int k = binarySearch(tasks,startTime);
            p[i] = k;
        }
        //创建数组dp,dp[i] 表示以任务i结尾的最大子任务集权重和
        int[] dp = new int[n];
        dp[0] = tasks[0].arr[0];
        //List<Integer> taskList = new ArrayList<>();
        //taskList.add(0);
        //存储每一个任务的最大权重得来的路径
        int[] path = new int[n];
        Arrays.fill(path,-1);
        for (int i = 1; i < n; i++) {
            if (p[i] == -1){
                dp[i] = Math.max(dp[i - 1],tasks[i].arr[0]);
                if (tasks[i].arr[0] <= dp[i - 1]){
                    path[i] = i - 1;
                }
            }else {
                dp[i] = Math.max(dp[i - 1],dp[p[i]] + tasks[i].arr[0]);
                if (dp[p[i]] + tasks[i].arr[0] > dp[i - 1]){
                    path[i] = p[i];
                }else {
                    path[i] = i - 1;
                }
            }
        }
        System.out.println(Arrays.toString(path));
        List<Integer> retPath = new ArrayList<>();
        /*int cur = n - 1;
        while (cur >= 0 && path[cur] != -1){
            if(path[path[cur]] != -1 && dp[path[path[cur]]] == dp[path[cur]]) {
                cur = path[cur];

                continue;
            }
            retPath.add(path[cur]);
            cur = path[cur];
        }*/
        int curIndex = n - 1;
        while (curIndex >= 0 && path[curIndex] != -1){
            int cur = dp[curIndex];
            while (dp[path[curIndex]] == cur){
                curIndex = path[curIndex];
            }
            retPath.add(curIndex);
            curIndex = path[curIndex];
        }
        retPath.add(curIndex);
        Collections.reverse(retPath);//逆序一下
        int[] ret = new int[retPath.size()];
        for (int i = 0; i < retPath.size(); i++) {
            int newIndex = retPath.get(i);
            int retIndex = tasks[newIndex].index;
            ret[i] = retIndex;
        }
        return ret;

    }

    private static int binarySearch(Task[] tasks, int target) {
        int left = 0,right = tasks.length - 1;
        int mid = left + (right - left)/2;
        while (left < right){
            if (tasks[mid].arr[2] > target){
                right = mid;
            }else if (tasks[mid].arr[2] <= target){
                left = mid + 1;
            }
            mid = left + (right - left)/2;
        }
        return left - 1;
    }

    private static int search(int[] arr,int target){
        int left = 0,right = arr.length - 1;
        int mid = left + (right - left)/2;
        while (left < right){
            if (arr[mid] > target){
                right = mid;
            }else if (arr[mid] <= target){
                left = mid + 1;
            }
            mid = left + (right - left)/2;
        }
        return left - 1;
    }

    static class Task{
        int[] arr;
        int index;//原始任务的索引
        public Task(int[] arr,int index){
            this.arr = arr;
            this.index= index;
        };
    }
}
