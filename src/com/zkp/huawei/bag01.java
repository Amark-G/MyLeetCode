package com.zkp.huawei;

/**
 * @author zkp
 * @version 1.0
 * 01背包问题：背包容量为 m,物品的价值为数组 v ,物品的重量为数组 w。求该背包能够装下的最大价值
 *
 */
public class bag01 {
   public static void main(String[] args){
      int m = 4;
      int[] w = {1,3,4};
      int[] v = {15,20,30};
      System.out.println(new bag01().method2(m, v, w));
   }

   /**
    * 方法一：二维数组的动态规划
    * @param m 背包容量
    * @param v 物品价值数组
    * @param w 物品重量数组
    * @return 该背包能够装下的最大价值
    */
   private int method1(int m,int[] v,int[] w){
      //构建二维数组dp, dp[i][j]表示从物品 0-i 中任意选取，容量 j 最多能够装下的价值
      //dp[i][j] 有两种情况：一种是不装第 i 个物品，此时dp[i][j] = dp[i - 1][j];
      //         情况二：装第 i 个物品，此时dp[i][j] = dp[i - 1][j - w[i]] + v[i];
      int[][] dp = new int[v.length][m + 1];
      //初始化dp
      for (int i = 0; i < m + 1; i++) {
         if (i >= w[0])
            dp[0][i] = v[0];
      }
      for (int i = 1; i < v.length; i++) {
         for (int j = 0; j < m + 1; j++) {
            if (j < w[i])
               dp[i][j] = dp[i - 1][j];//装不下物品i时
            else
               dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - w[i]] + v[i]);//能够装下物品i
         }
      }
      return dp[v.length - 1][m];
   }

   /**
    * 方法二：一维数组的动态规划
    * @param m 背包容量
    * @param v 物品价值数组
    * @param w 物品重量数组
    * @return 该背包能够装下的最大价值
    */
   private int method2(int m,int[] v,int[] w){
      //构建一维数组dp， dp[i] 表示背包容量为 i 时，能够装下的最大价值
      //此时需要一轮轮迭代，从只装第 0 号物品开始一直到讨论所有v.length 件物品
      //当讨论装第 0 到第 k 件物品时，dp[i]分两种情况：不装第 k 件物品时,dp[i] 和 上次迭代结构一样，即 dp[i] = dp[i - 1];
      //                                            装第 k 件物品时,dp[i] 为dp[i - w[k]] + v[k];(前提是装得下，即 i >= w[k]
      int[] dp = new int[m + 1];
      //初始化 dp 的第一次迭代
      for (int i = 0; i < m + 1; i++) {
         dp[i] = i >= w[0] ? v[0] : 0;
      }
      //开始迭代后面的物品
      for (int i = 1; i < v.length; i++) {
         for (int j = m; j >= w[i]; j--) {//倒序遍历容量，防止同一件物品被重复放入
               dp[j] = Math.max(dp[j],dp[j - w[i]] + v[i]);//如果能够装下第 i 号物品
         }
      }
      return dp[m];
   }
}
