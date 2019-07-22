package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 上午11:38 2019/7/5
 */
public class ImplementStrStr {


    /**
     *Implement strStr().
     Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

     Example 1:

     Input: haystack = "hello", needle = "ll"
     Output: 2
     Example 2:

     Input: haystack = "aaaaa", needle = "bba"
     Output: -1
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {

        if (needle.length()==0){
            return 0;
        }

        int i=0,j = 0;
        int next[] = next(needle);
        while (i<haystack.length()&&j<needle.length()){
            if (j==-1 || haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else {
                j = next[j];
            }

        }
        if (j==needle.length()){
            return i-j;
        }
        return -1;

    }

    private int[] next(String s){
        int next[] = new int[s.length()];
        int k =-1;
        int j=0;
        next[0] =-1;
        while (j<s.length()-1){
            if (k==-1 || s.charAt(j) == s.charAt(k)){
                next[++j] = ++k;
            }else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        ImplementStrStr implementStrStr = new ImplementStrStr();
        int i = implementStrStr.strStr("mississippi", "issi");
        System.out.println(i);
    }


}
