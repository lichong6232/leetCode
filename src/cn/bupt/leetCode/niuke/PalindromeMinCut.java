package cn.bupt.leetCode.niuke;

/**
 * Created by chongli on 2017/7/12.
 */
public class PalindromeMinCut {

    public int minCut(String s) {
        if (s == null||s.length()==0){
            return 0;
        }
        int dp[] = new int[s.length()+1];
        dp[s.length()] = -1;
        boolean p[][] = new boolean[s.length()][s.length()];
        for (int i=s.length()-1;i>=0;i--){
            dp[i] = Integer.MAX_VALUE;
            for (int j=i;j<s.length();j++){
                if (s.charAt(i) == s.charAt(j) && (j-i<2 || p[i+1][j-1])){
                    p[i][j] = true;
                    dp[i] = Math.min(dp[i],dp[j+1]+1);
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        PalindromeMinCut palindromeMinCut = new PalindromeMinCut();
        int minCut = palindromeMinCut.minCut("ab");
        System.out.println(minCut);
    }
}
