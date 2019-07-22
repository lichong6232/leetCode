package cn.bupt.leetCode.niuke.twice;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:12 2019/6/2
 */
public class ScrambleString {

    /**
     * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

     Below is one possible representation of s1 ="great":

     great
     /    \
     gr    eat
     / \    /  \
     g   r  e   at
     / \
     a   t
     To scramble the string, we may choose any non-leaf node and swap its two children.

     For example, if we choose the node"gr"and swap its two children, it produces a scrambled string"rgeat".

     rgeat
     /    \
     rg    eat
     / \    /  \
     r   g  e   at
     / \
     a   t
     We say that"rgeat"is a scrambled string of"great".

     Similarly, if we continue to swap the children of nodes"eat"and"at", it produces a scrambled string"rgtae".

     rgtae
     /    \
     rg    tae
     / \    /  \
     r   g  ta  e
     / \
     t   a
     We say that"rgtae"is a scrambled string of"great".

     Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()){
            return false;
        }
        if (s1.length() == 1){
            return s1.charAt(0) == s2.charAt(0);
        }
        char char1[] = s1.toCharArray();
        char char2[] = s2.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        for (int i=0;i<char1.length;i++){
            if (char1[i] !=char2[i]){
                return false;
            }
        }
        for (int i=1;i<s1.length();i++){
            String s1Left = s1.substring(0,i);
            String s1Right = s1.substring(i,s1.length());
            String s2Left = s2.substring(0,i);
            String s2Right = s2.substring(i,s2.length());
            if (isScramble(s1Left,s2Left) && isScramble(s1Right,s2Right)){
                return true;
            }
            s2Left = s2.substring(s2.length()-i);
            s2Right = s2.substring(0,s2.length()-i);
            if (isScramble(s1Left,s2Left) && isScramble(s1Right,s2Right)){
                return true;
            }
        }
        return false;

    }


    public static void main(String[] args) {
        ScrambleString scrambleString = new ScrambleString();
        boolean scramble = scrambleString.isScramble("rgtae", "great");
        System.out.println(scramble);
    }
}
