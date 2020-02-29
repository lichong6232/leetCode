package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:56 2019/10/8
 */
public class CountDifferentPalindromicSubsequences {

    /**
     * 参考文档:https://www.jianshu.com/p/d1d4414c97d2
     * @param S
     * @return
     */
    public int countPalindromicSubsequences(String S) {
        int MOD = 1000000007;
        int n = S.length();
        int dp[][] = new int[n][n];
        for (int j=0;j<n;j++){
            dp[j][j] = 1;
            for (int i=j-1;i>=0;i--){
                if (S.charAt(i) == S.charAt(j)){
                    dp[i][j] = 2*dp[i+1][j-1]%MOD;
                    int left = i+1;
                    int right = j-1;
                    while (left<=right && S.charAt(left)!=S.charAt(i)){
                        left++;
                    }
                    while (left<=right && S.charAt(right)!=S.charAt(i)){
                        right--;
                    }
                    if (left>right){
                        dp[i][j] =(dp[i][j]+2)%MOD;
                    }else if (left==right){
                        dp[i][j] = (dp[i][j]+1)%MOD;
                    }else {
                        dp[i][j] = (dp[i][j] - dp[left+1][right-1])%MOD;
                    }
                }else {
                    dp[i][j] = (dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1])%MOD;
                }
                dp[i][j] = (dp[i][j]+MOD) % MOD;
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        CountDifferentPalindromicSubsequences countDifferentPalindromicSubsequences = new CountDifferentPalindromicSubsequences();
        int ans = countDifferentPalindromicSubsequences.countPalindromicSubsequences("bccb");
        System.out.println(ans);
    }
}
