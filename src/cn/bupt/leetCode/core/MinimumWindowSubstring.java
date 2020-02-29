package cn.bupt.leetCode.core;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lichong04
 * @Date: Created in 下午2:57 2019/8/10
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length()<t.length()){
            return "";
        }

        Map<Character,Integer> t_map = new HashMap<>();
        for (char c : t.toCharArray()){
            t_map.put(c,t_map.getOrDefault(c,0)+1);
        }
        int count = 0;
        Map<Character,Integer> windowCount = new HashMap<>();
        int start=0,end=0;
        int minSize = Integer.MAX_VALUE,minStart=0,minEnd=-1;
        while (end<s.length()){
            char c = s.charAt(end);
            windowCount.put(c,windowCount.getOrDefault(c,0)+1);
            if (t_map.containsKey(c) && t_map.get(c).intValue() == windowCount.get(c).intValue()){
                count++;
            }
            while (start<=end-t.length()+1 && count == t_map.size()){
                int tempSize = end-start+1;
                if (tempSize<minSize){
                    minSize = tempSize;
                    minStart = start;
                    minEnd = end;
                }
                char lchar = s.charAt(start);
                windowCount.put(lchar,windowCount.get(lchar)-1);
                if (t_map.containsKey(lchar) && windowCount.get(lchar)<t_map.get(lchar)){
                    count--;
                }
                start++;
            }
            end++;
        }
        return s.substring(minStart,minEnd+1);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String s = "a",t="a";
        String minWindow = minimumWindowSubstring.minWindow(s, t);
        System.out.println(minWindow);
    }
}
