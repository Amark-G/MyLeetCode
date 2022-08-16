package com.zkp.huawei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @author zkp
 * @version 1.0
 */
public class HJ41 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> set = null;
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] m = new int[n];//砝码质量
            for (int i = 0; i < n; i++) {
                m[i] = sc.nextInt();
            }
            List<Integer> list = new ArrayList<>();//所有砝码的集合
            for (int i = 0; i < n; i++) {
                int count = sc.nextInt();
                for (int j = 0; j < count; j++) {
                    list.add(m[i]);
                }
            }
            set = new HashSet<>();//能称重的质量集合
            set.add(0);
            for (Integer addW : list) {
                Integer[] cur = new Integer[set.size()];
                cur = set.toArray(cur);
                for (Integer curW : cur) {
                    set.add(curW + addW);
                }
            }
        }
        System.out.println(set.size());

    }
}
