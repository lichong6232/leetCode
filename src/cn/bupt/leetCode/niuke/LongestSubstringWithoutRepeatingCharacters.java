package cn.bupt.leetCode.niuke;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lichong04
 * @Date: Created in 上午1:01 2019/4/30
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int max = 0,leftBound=0;
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            leftBound = Math.max(leftBound,map.containsKey(c)?map.get(c)+1:0);
            max = Math.max(max,i-leftBound+1);
            map.put(c,i);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        String s = "abcabcdefgh";
        int i = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
