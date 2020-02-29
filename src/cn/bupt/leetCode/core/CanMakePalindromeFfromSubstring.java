package cn.bupt.leetCode.core;

import java.util.*;

/**
 * @Author: lichong04
 * @Date: Created in 下午2:05 2019/9/27
 */
public class CanMakePalindromeFfromSubstring {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new ArrayList<>(queries.length);
        for (int i=0;i<queries.length;i++){
            int query[] = queries[i];
            int k = query[2];
            if (k>=13){
                result.add(true);
                continue;
            }
            int left = query[0];
            int right = query[1];
            int oddNumber = oddNumber(s, left, right);
            result.add(oddNumber<= 2*k+(right-left+1)%2);

        }
        return result;
    }

    private int oddNumber(String s,int left, int right){
        Map<Character,Integer> map = new HashMap<>();
        while (left<=right){
            map.put(s.charAt(left),map.getOrDefault(s.charAt(left++),0)+1);
        }
        int odd = 0;
        for (int num : map.values()){
            if (num%2!=0){
                odd++;
            }
        }
        System.out.println(odd);
        return odd;
    }




    public static void main(String[] args) {
        CanMakePalindromeFfromSubstring canMakePalindromeFfromSubstring = new CanMakePalindromeFfromSubstring();

        //int querys[][] = new int[][]{{1,1,1},{2,3,0},{3,3,1},{0,3,2},{1,3,3},{2,3,1},{3,3,1},{0,3,0},{1,1,1},{2,3,0},{3,3,1},{0,3,1},{1,1,1}};
        int querys[][] = new int[][]{{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}};

        List<Boolean> result = canMakePalindromeFfromSubstring.canMakePaliQueries("abcda", querys);
        System.out.println(result);


    }
}
