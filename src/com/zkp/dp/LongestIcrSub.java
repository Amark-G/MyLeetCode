package com.zkp.dp;

/**题300
 * 最长递增子序列
 * @author zkp
 * @version 1.0
 */
public class LongestIcrSub {

    /**
     * 时间复杂度 O(N*N)
     * @param nums:
     * @return:
     */
    public int lengthOfLIS(int[] nums){
        int length = nums.length;
        int[] dp = new int[length];//dp[i]表示以第i个元素结尾的最长递增子序列长度
        for (int i = 0; i < length; i++) {
            int max = 1;//以第i个元素结尾的最长递增子序列长度
            for (int j = 0; j < i; j++) {
                if (dp[i] > dp[j]){
                    max = Math.max(max,dp[j] + 1);
                }
            }
            dp[i] = max;
        }
        //遍历dp数组，找出最大值
        int ret = dp[0];
        for (int i = 1; i < length; i++) {
            ret = Math.max(ret,dp[i]);
        }
        return ret;
    }
}
