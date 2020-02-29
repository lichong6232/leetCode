package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:56 2019/9/25
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()+1][text2.length()+1];
        for (int i=1;i<dp.length;i++){
            for (int j=1;j<dp[i].length;j++){
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        String text1 = "abcde";
        String text2 = "ace";
        int i = longestCommonSubsequence.longestCommonSubsequence(text1, text2);
        System.out.println(i);
    }
}
