package com.zkp.math;



import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author zkp
 * @version 1.0
 * 丑数
 * 丑数乘以因子得到的还是丑数
 */
public class GetUglyNumber {

    public static void main(String[] args){
        GetUglyNumber test = new GetUglyNumber();
        System.out.println(test.getUglyNumber(1500));
    }

    public int getUglyNumber(int index) {
        if (index == 0) return 0;
        HashSet<Long> set = new HashSet<>();//存储丑数并且去重
        PriorityQueue<Long> queue = new PriorityQueue<>();//优先队列，每次取堆顶元素
        int[] factor = {2,3,5};
        //先加入1
        set.add(1L);
        queue.offer(1L);
        long ret = 1L;
        for (int i = 0; i < index; i++) {
            ret = queue.poll();//取堆顶元素
            for (int j = 0; j < 3; j++) {
                long next = factor[j] * ret;
                if(!set.contains(next)){
                    set.add(next);
                    queue.offer(next);
                }
            }
        }
        return (int) ret;
    }

}
