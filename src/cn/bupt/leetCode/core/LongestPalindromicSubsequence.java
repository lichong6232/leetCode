package cn.bupt.leetCode.core;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:07 2019/9/26
 */
public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];

        for (int i=0;i<n;i++){
            dp[i][i] = 1;
            for (int j=i-1;j>=0;j--){
                if (s.charAt(i) == s.charAt(j)){
                    dp[j][i] = dp[j+1][i-1]+2;
                }else {
                    dp[j][i] = Math.max(dp[j+1][i],dp[j][i-1]);

                }
            }

        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence longestPalindromicSubsequence = new LongestPalindromicSubsequence();
        String s = "bbbab";
        int i = longestPalindromicSubsequence.longestPalindromeSubseq(s);
        System.out.println(i);
    }
}
