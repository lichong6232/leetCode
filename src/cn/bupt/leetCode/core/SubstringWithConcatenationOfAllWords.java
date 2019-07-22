package cn.bupt.leetCode.core;

import java.util.*;

/**
 * @Author: lichong04
 * @Date: Created in 上午10:11 2019/7/6
 */
public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();

        if (words.length == 0){
            return list;
        }
        Map<String,Integer> wordMap = new HashMap<>(words.length);
        for (String word:words){
            if (wordMap.containsKey(word)){
                wordMap.put(word,wordMap.get(word)+1);
            }else {
                wordMap.put(word,1);
            }
        }
        int wordLength = words[0].length();
        for (int i=0;i<s.length();i++){
            Map<String,Integer> tempMap = new HashMap<>();
            int j=i;
            for (;j<(words.length*wordLength+i) && j<=s.length()-wordLength;j+=wordLength){
                String word = s.substring(j,j+wordLength);
                if (tempMap.containsKey(word)){
                    tempMap.put(word,tempMap.get(word)+1);
                }else {
                    tempMap.put(word,1);
                }
                if (wordMap.containsKey(word)){
                    if (tempMap.get(word)>wordMap.get(word)){
                        break;
                    }
                }else {
                    break;
                }
            }
            if (j==words.length*wordLength+i){
                list.add(i);
            }
        }
        return list;

    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords substringWithConcatenationOfAllWords = new SubstringWithConcatenationOfAllWords();
        List<Integer> list = substringWithConcatenationOfAllWords.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"});
        System.out.println(list);
    }


}
