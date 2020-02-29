package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 上午12:16 2019/3/28
 */
public class EditDistance {


    /**
     * 题目描述：
     * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

     You have the following 3 operations permitted on a word:

     a) Insert a character
     b) Delete a character
     c) Replace a character


     解题思路：
     通过动态规划dp[i][j]表示word1的前i个字符转换到word2的前j个字符所需要的步骤。
     所以动态规划的转换公式为：
     当word1的第i个字符与word2的第j个字符相等的时候，dp[i][j] = dp[i-1][j-1]
     当word1的第i个字符与word2的第J个字符不相等的时候，dp[i][j]需要根据以下三情况的最小步骤+1。
     1、word1的前i-1个字符转换到word2的前j个字符的最小步骤+1（word1的前i-1个字符经过变换变成了word2的前j个字符，则word2的前i个字符要想变成word2的前j个字符，只需要将word1的第i个字符删除）
     2、word1的前i个字符转换到word2的前j-1个字符的最小步骤+1（word1的前i个字符经过dp[i][j-1]次的变换变成了word2的前j-1个字符，
     word1的前i个字符要想变成word2的前j个字符，只需要在变成了的word2[0,j-1]的基础上加上word2的第j个字符）
     3、word1的前i-1个字符转换到word2的前j-1个字符的最小步骤+1(word1的第i个字符修改成word2的第j个字符)

     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for (int j =0 ;j<=word2.length();j++){
            dp[0][j] = j;
        }
        for (int i = 0;i<=word1.length();i++){
            dp[i][0] = i;
        }
        for (int i=1;i<=word1.length();i++){
            for (int j=1;j<=word2.length();j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {

    }

}
