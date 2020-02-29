package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午5:24 2019/9/26
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {

        int index = 0;
        for (char c: s.toCharArray()){
            boolean b =false;
            while (index<t.length()){
                if (t.charAt(index++) == c){
                    b =true;
                    break;
                }
            }
            if (!b){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        String s = "abc";
        String t ="ahbgdc";
        boolean subsequence = isSubsequence.isSubsequence(s, t);
        System.out.println(subsequence);
    }
}
