package cn.bupt.leetCode.niuke.twice;

import java.util.*;

/**
 * @Author: lichong04
 * @Date: Created in 下午1:29 2019/5/30
 */
public class WordBreak2 {

    /**
     * 问题描述：
     * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

     Return all such possible sentences.

     For example, given
     s ="catsanddog",
     dict =["cat", "cats", "and", "sand", "dog"].

     A solution is["cats and dog", "cat sand dog"].
     * @param s
     * @param dict
     * @return
     */
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int i = 0;i<s.length();i++){
            for (int j=i;j<s.length();j++){
                dp[i][j] = dict.contains(s.substring(i,j+1));
            }
        }
        ArrayList<String> result = new ArrayList<>();
        deep(s,dp,0,result,new ArrayList<>());
        return result;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        Set<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        WordBreak2 wordBreak2 = new WordBreak2();
        ArrayList<String> list = wordBreak2.wordBreak(s, dict);
        System.out.println(list);
    }

    private void deep(String s,boolean dp[][],int i,ArrayList<String> result,ArrayList<String> temp){
        if (i == s.length()){
            StringBuilder stringBuilder = new StringBuilder();
            for (int k = 0;k<temp.size();k++){
                stringBuilder.append(temp.get(k));
                stringBuilder.append(" ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            result.add(stringBuilder.toString());
        }else {
            for (int j=i;j<s.length();j++){
                if (dp[i][j]){
                    temp.add(s.substring(i,j+1));
                    deep(s,dp,j+1,result,temp);
                    temp.remove(temp.size()-1);
                }
            }
        }

    }
}
