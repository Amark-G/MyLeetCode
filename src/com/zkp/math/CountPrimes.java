package com.zkp.math;

/**
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 */
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n];//标记不是素数的数
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrimes[i]) continue;
            ++count;
            for(long j = (long) i*i;j<n;j+=i){
                notPrimes[(int)j] = true;//从i*i开始标记不是素数的数
            }
        }
        return count;
    }
}
