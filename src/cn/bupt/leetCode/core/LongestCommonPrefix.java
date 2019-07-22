package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午8:41 2019/6/23
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        return commonPrefix(strs,0,strs.length-1);
    }

    private String commonPrefix(String s[],int left,int rifht){
        if (left == rifht){
            return s[left];
        }
        int mid = (left+rifht)/2;
        String leftStr = commonPrefix(s, left, mid);
        String rightStr = commonPrefix(s, mid + 1, rifht);
        return commonPrefix(leftStr,rightStr);
    }

    private String commonPrefix(String str1,String str2){
        int minLen = Math.min(str1.length(),str2.length());
        for (int i=0;i<minLen;i++){
            if (str1.charAt(i)!=str2.charAt(i)){
                return str1.substring(0,i);
            }
        }
        return str1.substring(0,minLen);
    }
}
