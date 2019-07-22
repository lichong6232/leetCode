package cn.bupt.leetCode.niuke;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:18 2019/4/19
 */
public class ImplementStrstr {

    public String strStr(String haystack, String needle) {

        if (haystack == null || needle == null){
            return null;
        }
        if (needle.equals("")){
            return haystack;
        }
        int next[] = getNext(needle);
        int i=0,j=0;
        while (i<haystack.length() && j<needle.length()){
            if (j==-1 || haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else {
                j = next[j];
            }
            if (j==needle.length()){
                return haystack.substring(i-j);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String haystack = "a";
        String needle = "a";
        ImplementStrstr implementStrstr = new ImplementStrstr();
        String s = implementStrstr.strStr(haystack, needle);
        System.out.println(s);
    }

    private int[] getNext(String s){
        int next[] = new int[s.length()];
        next[0] = -1;
        int k =-1,j = 0;
        while (j<s.length()-1){
            if (k==-1 || s.charAt(j) == s.charAt(k)){
                ++k;
                ++j;
                next[j] = k;
            }else {
                k = next[k];
            }
        }
        return next;
    }
}
