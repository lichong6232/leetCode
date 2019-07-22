package cn.bupt.leetCode.niuke.twice;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:58 2019/5/30
 */
public class PalindromePartitioning2 {

    /**
     * 问题描述：
     * Given a string s, partition s such that every substring of the partition is a palindrome.

     Return the minimum cuts needed for a palindrome partitioning of s.

     For example, given s ="aab",
     Return1since the palindrome partitioning["aa","b"]could be produced using 1 cut.
     * @param s
     * @return
     */
    public int minCut(String s) {

        int dp[] = new int[s.length()+1];
        dp[s.length()] = -1;
        boolean tag[][] = new boolean[s.length()][s.length()];
        for (int i=s.length()-1;i>=0;i--){
            for (int j=i;j<s.length();j++){
                if (s.charAt(i) == s.charAt(j) && (j-i<2 || tag[i][j])){
                    tag[i][j] = true;
                    dp[i] = Math.min(dp[i],dp[j+1]+1);
                }
            }
        }
        return dp[0];
    }
}
