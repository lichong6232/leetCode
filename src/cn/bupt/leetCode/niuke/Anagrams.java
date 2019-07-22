package cn.bupt.leetCode.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lichong04
 * @Date: Created in 下午2:06 2019/4/6
 */
public class Anagrams {

    /**
     *
     * Given an array of strings, return all groups of strings that are anagrams.

     Note: All inputs will be in lower-case.
     * @param strs
     * @return
     */
    public ArrayList<String> anagrams(String[] strs) {

        ArrayList<String> result = new ArrayList<>();
        Map<String,ArrayList<String>> map = new HashMap<>();
        for (String s : strs){
            char c[] = s.toCharArray();
            Arrays.sort(c);
            map.compute(String.valueOf(c),(k,v)->{

                if (v==null){
                    ArrayList<String> list = new ArrayList<>();
                    list.add(s);
                    return list;
                }
                v.add(s);
                return v;
            });
        }
        for (Map.Entry<String,ArrayList<String>> entry : map.entrySet()){
            ArrayList<String> list = entry.getValue();
            if (list.size()>1){
                result.addAll(list);
            }
        }
        return result;
    }
}
