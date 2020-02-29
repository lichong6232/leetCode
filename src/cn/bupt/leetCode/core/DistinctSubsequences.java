package cn.bupt.leetCode.core;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:46 2019/9/27
 */
public class DistinctSubsequences {


    /**
     * This problem can be seen as a special match problem (10. Regular Expression Matching, 44. Wildcard Matching, 1023. Camelcase Matching) Normally, a match problem is related to substring while this one is related to subsequence. Such problem can be solved in dp. Here, we a two dimension array sum[i][j] to denote the number of subsequence of s[0, i] that can match t[0, j]:

     Apparently, if j == 0, then there must be one subsequence, i.e., empty string to match it.
     If s[i] == t[j], then sum[i][j] = sum[i - 1][j - 1] + sum[i - 1][j]
     Otherwiese, sum[i][j] = sum[i - 1][j].
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n+1][m+1];
        for (int i=0;i<=n;i++){
            dp[i][0] = 1;
        }
        for (int i=1;i<=n;i++){
            for (int j=1;j<=i&&j<=m;j++){
                if (s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
        String s = "aaaaa",t = "aa";
        int i = distinctSubsequences.numDistinct(s, t);
        System.out.println(i);
    }
}
