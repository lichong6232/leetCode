package cn.bupt.leetCode;

import java.util.ArrayList;

/**
 * Created by chongli on 2017/7/12.
 */
public class AllPossiblePalindrome {

    public static void main(String args[]){
        AllPossiblePalindrome allPossiblePalindrome = new AllPossiblePalindrome();
        System.out.println(allPossiblePalindrome.partition("aab"));
    }

    public ArrayList<ArrayList<String>> partition(String s) {

        dfs(s,0);
        return resultList;

    }
    private ArrayList<String> currList = new ArrayList<String>();
    private ArrayList<ArrayList<String>> resultList = new ArrayList<ArrayList<String>>();
    private void dfs(String s,int i){
        if (currList.size()>0 && i==s.length()){
            resultList.add((ArrayList<String>) currList.clone());
            return;
        }
        for (int j=i;j<s.length();j++){
            if (isPalindrome(s,i,j)){
                currList.add(s.substring(i,j+1));
                dfs(s,j+1);
                currList.remove(currList.size()-1);
            }
        }

    }

    private boolean isPalindrome(String s,int i,int j){
        while (i< j){
            if (s.charAt(i) != s.charAt(j))
                return false;
            ++i;
            --j;
        }
        return true;
    }
}
