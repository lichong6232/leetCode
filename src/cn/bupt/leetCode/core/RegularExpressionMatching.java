package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午2:25 2019/6/23
 */
public class RegularExpressionMatching {


    /**
     *Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

     '.' Matches any single character.
     '*' Matches zero or more of the preceding element.
     The matching should cover the entire input string (not partial).
     Note:

     s could be empty and contains only lowercase letters a-z.
     p could be empty and contains only lowercase letters a-z, and characters like . or *.
     Example 1:
     Input:
     s = "aa"
     p = "a"
     Output: false
     Explanation: "a" does not match the entire string "aa".
     Example 2:

     Input:
     s = "aa"
     p = "a*"
     Output: true
     Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (p.length() == 0){
            return s.length() == 0;
        }
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i=1;i <= p.length();i++){
            dp[0][i] = dp[0][i-1] && s.charAt(i-1) =='*';
        }

        for (int i=1;i<=s.length();i++){
            for (int j=1;j<=p.length();j++){
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) =='.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if (p.charAt(j-1) == '*'){
                    if (s.charAt(i-1)!= p.charAt(j-2) && p.charAt(j-2)!='.' ){
                        dp[i][j] = dp[i][j-2];
                    }else {
                        dp[i][j] = dp[i][j-2] || dp[i][j-1] || dp[i-1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];

    }

}
