package cn.bupt.leetCode.niuke.twice;

/**
 * @Author: lichong04
 * @Date: Created in 上午1:25 2019/6/2
 */
public class InterleavingString {

    /**
     * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

     For example,
     Given:
     s1 ="aabcc",
     s2 ="dbbca",

     When s3 ="aadbbcbcac", return true.
     When s3 ="aadbbbaccc", return false.
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Length = s1.length(),s2Length = s2.length(),s3Length = s3.length();
        if (s1Length+s2Length!=s3Length){
            return false;
        }
        boolean dp[][] = new boolean[s1Length+1][s2Length+1];
        dp[0][0] = true;
        for (int i=1;i<=s1Length;i++){
            dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }
        for (int j=1;j<=s2Length;j++){
            dp[0][j] = dp[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
        }
        for (int i=1;i<s1Length;i++){
            for (int j=1;j<s2Length;j++){
                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1))
                        || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }
        return dp[s1Length][s2Length];
    }
}
