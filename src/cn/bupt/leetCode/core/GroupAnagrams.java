package cn.bupt.leetCode.core;

import java.util.*;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:47 2019/8/5
 */
public class GroupAnagrams {

    /**
     * Given an array of strings, group anagrams together.

     Example:

     Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
     Output:
     [
     ["ate","eat","tea"],
     ["nat","tan"],
     ["bat"]
     ]
     Note:

     All inputs will be in lowercase.
     The order of your output does not matter.

     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs){
            String sortString = getCountString(str);
            if (map.containsKey(sortString)){
                map.get(sortString).add(str);
            }else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortString,list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String strs[] = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = groupAnagrams.groupAnagrams(strs);
        System.out.println(lists);
    }

    private String getCountString(String s){
        char[] chars = s.toCharArray();
        int counts[] = new int[26];
        for (char c : chars){
            counts[c-'a']++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int count : counts){
            stringBuilder.append(count);
            stringBuilder.append("#");
        }
        return stringBuilder.toString();
    }

    private String getSortString(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
