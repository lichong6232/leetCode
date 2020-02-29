package cn.bupt.leetCode.core;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午1:05 2019/9/26
 */
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        for (int j=0;j<n;j++){
            dp[j][j]=true;
            for (int i=j-1;i>=0;i--){
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j==i+1 || dp[i+1][j-1]);
            }
        }

        int ans = 0;
        for (int i=0;i<n;i++){
            for (int j=0;j<=i;j++){
                if (dp[j][i]){
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        String s= "aaa";
        int i = palindromicSubstrings.countSubstrings(s);
        System.out.println(i);
    }
}
