package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午6:43 2019/4/28
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        for (int i=0;i<strs[0].length();i++){
            char c = strs[0].charAt(i);
            for (int j=1;j<strs.length;j++){
                if (strs[j].length() == i || strs[j].charAt(i) != c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }


    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String strs[] = new String[]{""};
        String s = longestCommonPrefix.longestCommonPrefix(strs);
        System.out.println(s);
    }
}
