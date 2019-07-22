package cn.bupt.leetCode.core;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:41 2019/6/21
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int result = 0;
        Map<Character,Integer> map = new HashMap<>(s.length());
        for (int i=0,j=0;j<s.length();j++){
            if (map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }
            result = Math.max(result,j-i+1);
            map.put(s.charAt(j),j+1);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        int i = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
