package cn.bupt.leetCode.niuke;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:24 2019/3/28
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int k = digits.length - 1;
        while (k >=0 && digits[k] == 9){
            digits[k] =0;
            k--;
        }
        if (k>=0){
            digits[k] = digits[k]+1;
            return digits;
        }
        int result[] = new int[digits.length+1];
        result[0]=1;
        return result;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int a[] = new int[]{9,9,9};
        int[] ints = plusOne.plusOne(a);
        System.out.println(Arrays.toString(ints));
    }
}
