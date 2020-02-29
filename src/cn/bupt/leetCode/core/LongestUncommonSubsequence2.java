package cn.bupt.leetCode.core;

import java.util.*;

/**
 * @Author: lichong04
 * @Date: Created in 下午1:52 2019/10/8
 */
public class LongestUncommonSubsequence2 {


    public int findLUSlength(String[] strs) {
        Map<String,Integer> map = new HashMap<>(strs.length);
        for (String str : strs){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        if (map.size()==1){
            return -1;
        }
        List<String> list = new ArrayList<>();
        list.addAll(map.keySet());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        });
        for (int i=0;i<list.size();i++){
            if (map.get(list.get(i))==1 && !isSubSequence(list,i-1,list.get(i))){
                return list.get(i).length();
            }

        }
        return -1;
    }

    private boolean subSequence(String s1,String s2){
        int i=0,j=0;
        while (i<s1.length() && j<s2.length()){
            if (s1.charAt(i) == s2.charAt(j)){
                j++;
            }
            i++;
        }
        return j == s2.length();
    }

    private boolean isSubSequence(List<String> list,int end, String s){
        for (int i=0;i<=end;i++){
            if (subSequence(list.get(i),s)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LongestUncommonSubsequence2 longestUncommonSubsequence2 = new LongestUncommonSubsequence2();
        String strs[] = new String[]{"aaa","aaa","aa"};
        int luSlength = longestUncommonSubsequence2.findLUSlength(strs);
        System.out.println(luSlength);
    }

}
