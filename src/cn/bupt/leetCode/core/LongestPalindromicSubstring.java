package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午7:29 2019/6/22
 */
public class LongestPalindromicSubstring {

    /**
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

     Example 1:

     Input: "babad"
     Output: "bab"
     Note: "aba" is also a valid answer.
     Example 2:

     Input: "cbbd"
     Output: "bb"
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null ){
            return null;
        }
        if (s.length() == 0){
            return "";
        }
        int left=0,right=0,max = 0;
        int dp[][] = new int[s.length()][s.length()];
        for (int j=0;j<s.length();j++){
            dp[j][j] = 1;
            for (int i=j-1;i>=0;i--){
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == j-i-1){
                    dp[i][j] = dp[i+1][j-1] +2;
                    if (j-i+1>max){
                        left = i;
                        right = j;
                        max = j-i+1;
                    }
                }else {
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }

        return s.substring(left,right+1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        String s = "babaddtattarrattatddetartrateedredividerb";
        String s1 = longestPalindromicSubstring.longestPalindrome(s);
        System.out.println(s1);
    }

}
