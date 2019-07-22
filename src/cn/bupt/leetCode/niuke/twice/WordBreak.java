package cn.bupt.leetCode.niuke.twice;

import java.util.Set;

/**
 * @Author: lichong04
 * @Date: Created in 下午12:38 2019/5/30
 */
public class WordBreak {

    /**
     * 问题描述
     * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

     For example, given
     s ="leetcode",
     dict =["leet", "code"].

     Return true because"leetcode"can be segmented as"leet code".
     * @param s
     * @param dict
     * @return
     */
    public boolean wordBreak(String s, Set<String> dict){
        if (s == null || s.length() ==0 || dict == null || dict.size() ==0){
            return false;
        }
        int sLength = s.length();
        boolean dp[] = new boolean[sLength+1];
        dp[0] = true;
        for (int i=1;i<=sLength;i++){
            for (int j=0;j<i;j++){
                if (dp[j] && dict.contains(s.substring(j,i))){
                    dp[i] = true;
                }
            }
        }
        return dp[sLength];
    }

}
