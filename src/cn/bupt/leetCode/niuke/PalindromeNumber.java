package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:46 2019/4/29
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }

        int hi =1;
        while (x/hi>=10){
            hi *=10;
        }
        while (x!=0){
            int left = x/hi;
            int right = x%10;
            if (left!=right){
                return false;
            }
            x = (x%hi)/10;
            hi = hi/100;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        boolean palindrome = palindromeNumber.isPalindrome(1001);
        System.out.println(palindrome);
    }

}
