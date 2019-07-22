package cn.bupt.leetCode.niuke;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:59 2019/4/27
 */
public class LetterCombinationsOfAPhoneNumber {

    public ArrayList<String> letterCombinations(String digits) {
        String strMap[] = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ArrayList<String> result = new ArrayList<>();
        List<Character> tmp = new ArrayList<>();
        char digit[] = digits.toCharArray();
        deep(0,tmp,result,strMap,digit);
        return result;
    }

    private void deep(int pos, List<Character> tmp, ArrayList<String> result, String[] strMap, char[] digits){
        if (pos==digits.length){
            result.add(charList2Str(tmp));
        }else {
            int digit = digits[pos]-'0';
            if (digit <=1){
                deep(pos+1,tmp,result,strMap,digits);
            }else {
                for (char c : strMap[digit].toCharArray()){
                    tmp.add(c);
                    deep(pos+1,tmp,result,strMap,digits);
                    tmp.remove(tmp.size()-1);
                }
            }

        }

    }

    private String charList2Str(List<Character> list){
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : list){
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        /*ArrayList<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        Character c[] = new Character[3];
        System.out.println(Arrays.toString(list.toArray(c)));*/
        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        ArrayList<String> result = letterCombinationsOfAPhoneNumber.letterCombinations("23");
        System.out.println(result);
    }
}
