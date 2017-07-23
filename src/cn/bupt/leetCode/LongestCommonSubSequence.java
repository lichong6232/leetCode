package cn.bupt.leetCode;

/**
 * Created by chongli on 2017/7/20.
 */
public class LongestCommonSubSequence {

    public static void main(String args[]){
        LongestCommonSubSequence longestCommonSubSequence=new LongestCommonSubSequence();
        System.out.println();
    }

    public int findLCS(String A, int n, String B, int m) {
        if (n==0 || m==0)
            return 0;
        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for (int j=1;j<=m;j++){
                if (A.charAt(i-1)==B.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public int findLCS1(String A, int n, String B, int m) {
        if (n==0 || m==0)
            return 0;
        int dp[][]=new int[n][m];
        if (A.charAt(0)==B.charAt(0)){
            dp[0][0]=1;
        }
        for (int i=1;i<n;i++){
            if (A.charAt(i)==B.charAt(0)){
                dp[i][0]=1;
            }else {
                dp[i][0]=dp[i-1][0];
            }
            for (int j=1;j<m;j++){
                if (B.charAt(j)==A.charAt(0)){
                    dp[0][j]=1;
                }else {
                    dp[0][j]=dp[0][j-1];
                }
                if (A.charAt(i)==B.charAt(j)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[n-1][m-1];
    }
}
