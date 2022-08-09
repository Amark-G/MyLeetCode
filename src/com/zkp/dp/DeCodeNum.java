package com.zkp.dp;

/**
 * @author zkp
 * @version 1.0
 */
public class DeCodeNum {

    public static void main(String[] args){
        DeCodeNum test = new DeCodeNum();
        System.out.println(test.solve("31717126241541717"));
    }
    public int solve (String nums) {
        if(nums.charAt(0) == '0') return 0;//首位为0，无法解码
        if(nums.length() < 2) return 1;//长度为1，一种解码
        int len = nums.length();
        int[] dp = new int[len];
        dp[0] = 1;
        int checkCase = (nums.charAt(0) - '0') * 10 + (nums.charAt(1) - '0');
        if (nums.charAt(1) == '0'){
            //第二位字符为0
            if (checkCase > 26) return 0;
            dp[1] = 1;
        }else{
            //第二位字符不为0
            dp[1] = checkCase > 26 ? 1 : 2;
        }
        for(int i = 2;i < len ;i++){
            int check = (nums.charAt(i - 1) - '0') * 10 + (nums.charAt(i) - '0');
            if(nums.charAt(i) == '0'){
                //当前位字符位0
                if (check > 26 || check == 0) return 0;
                dp[i] = dp[i - 2];
            }else if(nums.charAt(i - 1) == '0'){
                //前一位字符为0
                dp[i] = dp[i - 1];
            }else{
                //当前位和前一位字符都不为0
                dp[i] = check > 26 ? dp[i - 1] : dp[i - 1] + dp[i -2];
            }
        }
        return dp[len - 1];
    }
}
