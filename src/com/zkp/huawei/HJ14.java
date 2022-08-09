package com.zkp.huawei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * @author zkp
 * @version 1.0
 */
public class HJ14 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<String> queue = new PriorityQueue<>();
        for(int i = 0;i < n;i++){
            queue.offer(br.readLine());
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll()
            );
        }
    }
}
