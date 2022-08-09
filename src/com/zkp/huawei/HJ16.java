package com.zkp.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zkp
 * @version 1.0
 */
public class HJ16 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);//预算
        int m = Integer.parseInt(line1[1]);//一共的商品数量
        int[] v = new int[m];
        int[] w = new int[m];
        int[] q = new int[m];
        for (int i = 0; i < m; i++) {
            String[] str = br.readLine().split(" ");
            v[i] = Integer.parseInt(str[0]) * Integer.parseInt(str[1]);
            w[i] = Integer.parseInt(str[0]);
            q[i] = Integer.parseInt(str[2]);
        }



        int[] dp = new int[n / 10 + 1];//dp[i] 表示预算是10 * i 时可获得的最大满意度
        //初始化
        if (q[0] == 0){
            for (int i = w[0] / 10; i < n / 10 + 1; i++) {
                dp[i] = v[0];
            }
        }else{
            for (int i = (w[0] + w[q[0] - 1]) / 10; i < n / 10 + 1; i++) {
                dp[i] = v[0] + v[q[0] - 1];
            }
        }
        //两种情况：装得下第k号商品和装不下第k号商品
        for (int i = 1; i < w.length; i++) {
            if (q[i] == 0){
                for (int j = dp.length - 1; j >= w[i] / 10 ; j--) {
                    dp[j] = Math.max(dp[j],dp[j - w[i] / 10] + v[i]);
                }
            }else{
                for (int j = dp.length - 1; j >= (w[i] + w[q[i] - 1]) / 10; j--) {
                    dp[j] = Math.max(dp[j],dp[j - w[i] / 10 - w[q[i] - 1] / 10] + v[i] + v[q[i] - 1]);
                }
            }
        }
        System.out.println(dp[n / 10]);

    }
}
