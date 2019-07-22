package cn.bupt.leetCode.niuke.twice;

/**
 * @Author: lichong04
 * @Date: Created in 下午1:56 2019/6/1
 */
public class DistinctSubsequences {


    /**
     * Given a string S and a string T, count the number of distinct subsequences of T in S.

     A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie,"ACE"is a subsequence of"ABCDE"while"AEC"is not).

     Here is an example:
     S ="rabbbit", T ="rabbit"

     Return3.
     * @param S
     * @param T
     * @return
     */
    public int numDistinct(String S, String T) {

        int dp[][] = new int[S.length()+1][T.length()+1];
        dp[0][0]=1;
        for (int i=1;i<=S.length();i++){
            dp[i][0] = 1;
            for (int j=1;j<=T.length();j++){
                if (S.charAt(i-1) == T.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[S.length()-1][T.length()-1];
    }

    public static void main(String[] args) {
        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
        System.out.println(distinctSubsequences.numDistinct("rabbbit","rabbit"));
    }

}
