package cn.bupt.leetCode.niuke.twice;

import java.util.ArrayList;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:27 2019/5/30
 */
public class PalindromePartitioning {

    public ArrayList<ArrayList<String>> partition(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int i=0;i<s.length();i++){
            for (int j=i;j<s.length();j++){
                dp[i][j] = isPalindrome(s,i,j);
            }
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        deep(result,new ArrayList<>(),s,0,dp);
        return result;

    }

    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        ArrayList<ArrayList<String>> result = palindromePartitioning.partition("aab");
        System.out.println(result);
    }

    private void deep(ArrayList<ArrayList<String>> result, ArrayList<String> temp,String s,int i,boolean[][] dp){
        if (i == s.length()){
            result.add(new ArrayList<>(temp));
        }else {
            for (int j=i;j<s.length();j++){
                if (dp[i][j]){
                    temp.add(s.substring(i,j+1));
                    deep(result,temp,s,j+1,dp);
                    temp.remove(temp.size()-1);
                }
            }
        }

    }

    private boolean isPalindrome(String s,int i,int j){
        while (i<j){
            if (s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }
}
