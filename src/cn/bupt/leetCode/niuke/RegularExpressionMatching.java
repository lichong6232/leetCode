package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午1:10 2019/4/29
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {

        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i=1;i<dp[0].length;i++){
            if (p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-2];
            }
        }

        for (int i=1;i<dp.length;i++){
            for (int j=1;j<dp[i].length;j++){
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if (p.charAt(j-1) == '*'){
                    if (s.charAt(i-1)!=p.charAt(j-2) && p.charAt(j-2)!='.'){
                        dp[i][j] = dp[i][j-2];
                    }else {
                        dp[i][j] = dp[i][j-2] || dp[i][j-1] || dp[i-1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
        String s = "aaaaaab";
        String p = "a*b";
        boolean match = regularExpressionMatching.isMatch(s, p);
        System.out.println(match);
    }
}
