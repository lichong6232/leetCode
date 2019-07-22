package cn.bupt.leetCode.niuke;

/**
 * Created by chongli on 2017/7/20.
 */
public class LongestIncreasingSubsequence {

    public static void main(String args[]){
        int A[]={6,4,3,5,7,9,8,2,1};
        LongestIncreasingSubsequence longestIncreasingSubsequence=new LongestIncreasingSubsequence();
        System.out.println(longestIncreasingSubsequence.getLIS(A,A.length));
    }

    public int getLIS(int[] A, int n) {
        // write code here
        if (A==null||n==0)
            return 0;
        int dp[]=new int[n];
        dp[0]=1;
        int res=1;
        for(int i=1;i<n;i++){
            int temMax=0;
            for (int j=0;j<i;j++){
                if (A[i]>A[j]){
                    temMax=Math.max(temMax,dp[j]);
                }
            }
            dp[i]=temMax+1;
            if (res<dp[i]){
                res=dp[i];
            }
        }
        return res;
    }
}
