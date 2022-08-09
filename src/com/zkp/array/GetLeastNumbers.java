package com.zkp.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**优先队列寻找最小的k个数
 * @author zkp
 * @version 1.0
 */
public class GetLeastNumbers {
    public static void main(String[] args){
        GetLeastNumbers test = new GetLeastNumbers();
        int[] input = {4,5,1,6,2,7,3,8};
        System.out.println(test.getLeastNumbers_Solution(input, 8));
    }

    public ArrayList<Integer> getLeastNumbers_Solution(int [] input, int k) {
        if(k == 0 || input.length == 0)return new ArrayList<>();
        //优先队列
        ArrayList<Integer> ret = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1,o2) -> o2.compareTo(o1)));
        for (int i = 0; i < k; i++) {
            queue.offer(input[i]);
        }
        for (int i = k; i < input.length; i++) {
            if (input[i] < queue.peek()) {
                queue.poll();
                queue.offer(input[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            ret.add(queue.poll());
        }
        return ret;
    }

}
