package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 上午11:34 2019/6/23
 */
public class PalindromeNumber {


    public boolean isPalindrome(int x) {
        if (x < 0 || (x%10 == 0 && x!=0)){
            return false;
        }
        int reversedNuber = 0;
        while (x > reversedNuber){
            reversedNuber = 10*reversedNuber+x%10;
            x/=10;
        }
        System.out.println(x);
        return x == reversedNuber || x == reversedNuber/10;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        boolean palindrome = palindromeNumber.isPalindrome(12321);
        System.out.println(palindrome);

    }

}
