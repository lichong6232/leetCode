package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:30 2019/4/19
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {

        if (divisor == 0 || (dividend == Integer.MAX_VALUE && divisor == -1)){
            return Integer.MAX_VALUE;
        }
        boolean resultPositive = (dividend>0 ^ divisor>0) ? false : true;
        long did= Math.abs((long) dividend);
        long dis = Math.abs((long) divisor);
        int result = 0;
        while (did>=dis){
            long tmp = dis,mult = 1;
            while (did>=(tmp<<1)){
                tmp<<=1;
                mult<<=1;
            }
            did-=tmp;
            result += mult;
        }
        return resultPositive?result:-result;
    }

    public static void main(String[] args) {
        int dividend = 14,divisor = 3;
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        int divide = divideTwoIntegers.divide(dividend, divisor);
        System.out.println(divide);
    }
}
