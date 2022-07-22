package com.zkp.dp;

/**题91
 * 一条包含字母A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 *
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为(1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 *
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。

 */
public class NumDecodings {

    public static void main(String[] args){
        NumDecodings numDecodings = new NumDecodings();
        int count = numDecodings.numDecodings("0");
        System.out.println(count);
    }
    public int numDecodings(String s) {
        if (s.equals("0")) return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<= len;++i){
            if ((s.charAt(i-1) == '0') &&( (s.charAt(i-2) - '0') ==0 || (s.charAt(i-2) - '0')>2)){//出现0且前一个字符为0或者大于2时，无法解码
                return 0;
            }
            if(s.charAt(i-1) == '0'){
                dp[i] = dp[i-2];
            }else if((s.charAt(i-2) -'0')*10 + (s.charAt(i-1) - '0') <= 26 && s.charAt(i-2)!='0'){
                dp[i] = dp[i-1] + dp[i-2];
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[len];
    }
}
