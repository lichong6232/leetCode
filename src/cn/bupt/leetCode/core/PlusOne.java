package cn.bupt.leetCode.core;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午2:27 2019/8/10
 */
public class PlusOne {

    /**
     * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

     The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

     You may assume the integer does not contain any leading zero, except the number 0 itself.

     Example 1:

     Input: [1,2,3]
     Output: [1,2,4]
     Explanation: The array represents the integer 123.
     Example 2:

     Input: [4,3,2,1]
     Output: [4,3,2,2]
     Explanation: The array represents the integer 4321.

     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i=digits.length-1;i>=0;i--){
            int temp = digits[i];
            digits[i] = (temp+carry)%10;
            carry = (temp+carry)/10;
        }
        if (carry!=0){
            int newDigits[]= new int[digits.length+1];
            newDigits[0] = carry;
            for (int i=0;i<digits.length;i++){
                newDigits[i+1] = digits[i];
            }
            return newDigits;
        }
        return digits;
    }

    public static void main(String[] args) {
        int digits[] = new int[]{9,9,9};
        PlusOne plusOne = new PlusOne();
        int[] ints = plusOne.plusOne(digits);
        System.out.println(Arrays.toString(ints));
    }
}
