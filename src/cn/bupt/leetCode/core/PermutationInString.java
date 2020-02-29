package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:35 2019/10/26
 */
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length()>s2.length()){
            return false;
        }
        int num1[] = new int[26];
        int num2[] = new int[26];
        for (int i=0;i<s1.length();i++){
            num1[s1.charAt(i)-'a']++;
            num2[s2.charAt(i)-'a']++;
        }

        for (int i=0;i<s2.length()-s1.length();i++){
            if (match(num1,num2)){
                return true;
            }
            num2[s2.charAt(i+s1.length())-'a']++;
            num2[s2.charAt(i)-'a']--;
        }
        return match(num1,num2);
    }

    private boolean match(int num1[],int num2[]){
        for (int i=0;i<num1.length;i++){
            if (num1[i]!=num2[i]){
                return false;
            }
        }
        return true;
    }
}
