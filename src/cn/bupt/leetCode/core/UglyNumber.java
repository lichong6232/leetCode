package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午6:15 2019/10/26
 */
public class UglyNumber {

    public boolean isUgly(int num) {
        if (num==0){
            return false;
        }

        while (num!=1){
            if (num%2==0){
                num/=2;
            }else if (num%3==0){
                num/=3;
            }else if (num%5==0){
                num/=5;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        boolean ugly = uglyNumber.isUgly(14);
        System.out.println(ugly);
    }
}
