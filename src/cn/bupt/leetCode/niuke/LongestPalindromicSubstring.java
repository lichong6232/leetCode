package cn.bupt.leetCode.niuke;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:19 2019/4/29
 */
public class LongestPalindromicSubstring {


    public String longestPalindrome(String s) {
        if (s == null || s.length()==0){
            return "";
        }
        boolean dp[][] = new boolean[s.length()][s.length()];
        int left = 0,right = 0,maxLength = 0;
        for (int j=0;j<dp.length;j++){
            dp[j][j] = true;
            for (int i=j-1;i>=0;i--){
                if (s.charAt(i) == s.charAt(j) && (i==j-1 || dp[i+1][j-1])){
                    if (j-i+1>maxLength){
                        maxLength = j-i+1;
                        left = i;
                        right = j;
                    }
                    dp[i][j] = true;
                }
            }
        }
        return s.substring(left,right+1);

    }

    private static int longest(String s){
        int dp[][] = new int[s.length()][s.length()];
        int left = 0,right = 0;
        for (int j=0;j<dp.length;j++){
            dp[j][j] = 1;
            for (int i=j-1;i>=0;i--){
                if (s.charAt(i) == s.charAt(j)){
                    if (i==j-1 || dp[i+1][j-1] == j-i-1){
                        dp[i][j] = dp[i+1][j-1]+2;
                        left = i;
                        right = j;
                    }else {
                        dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                    }
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        System.out.println(left);
        System.out.println(right);
        return dp[0][s.length()-1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        String s = "aaabaaaa";
//        System.out.println(longest(s));
        System.out.println(longestPalindromicSubstring.longestPalindrome(s));
    }

}
