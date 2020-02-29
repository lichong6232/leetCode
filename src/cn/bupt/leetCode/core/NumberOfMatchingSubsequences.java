package cn.bupt.leetCode.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: lichong04
 * @Date: Created in 下午12:00 2019/9/27
 */
public class NumberOfMatchingSubsequences {

    private boolean isSubsequence(String s,String subsequence){
        int j=0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i) == subsequence.charAt(j)){
                j++;
            }
            if (j == subsequence.length()){
                return true;
            }

        }
        return false;
    }

    public int numMatchingSubseq(String S, String[] words) {
        int ans = 0;
        Map<String,Integer> map = new HashMap<>();
        for (String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        for (Map.Entry<String,Integer> entry:map.entrySet()){
            if (isSubsequence(S,entry.getKey())){
                ans+=entry.getValue();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberOfMatchingSubsequences numberOfMatchingSubsequences = new NumberOfMatchingSubsequences();
        String s = "abcde";
        String[] words = new String[]{"a", "bb", "acd", "ace"};
        int i = numberOfMatchingSubsequences.numMatchingSubseq(s, words);
        System.out.println(i);
    }
}
