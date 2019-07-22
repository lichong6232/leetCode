package cn.bupt.leetCode.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: lichong04
 * @Date: Created in 下午10:07 2019/6/23
 */
public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0){
            return result;
        }
        Map<Character,String> map = new HashMap<>(8);
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        dfs(digits.toCharArray(),0,result,new StringBuilder(),map);
        return result;
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber letLetterCombinationsOfAPhoneNumbert = new LetterCombinationsOfAPhoneNumber();
        List<String> list = letLetterCombinationsOfAPhoneNumbert.letterCombinations("23");
        System.out.println(list);
    }

    private void dfs(char c[], int i, List<String> result, StringBuilder temp, Map<Character,String> map){
        if (i == c.length){
            result.add(temp.toString());
            return;
        }
        String s = map.get(c[i]);
        for (Character character : s.toCharArray()){
            temp.append(character);
            dfs(c,i+1,result,temp,map);
            temp.deleteCharAt(temp.length()-1);
        }
    }

}
