package com.zkp.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class NumSquares {
    public static void main(String[] args){
        System.out.println(numSquares(9));
    }
    public static int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        int res = 0;
        queue.offer(n);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- >0){
                int target = queue.poll();
                //将其可能子数加入队列
                int temp =target;
                while (temp>0){
                    int k = (int)Math.pow((int)Math.sqrt(temp),2);
                    if (target-k ==0){
                        return res+1;
                    }
                    queue.offer(target-k);
                    temp = k-1;
                }
            }
            ++res;
        }
        return -1;
    }
}
